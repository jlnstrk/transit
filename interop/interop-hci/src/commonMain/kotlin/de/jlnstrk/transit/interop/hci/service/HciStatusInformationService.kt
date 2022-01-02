package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.himsearch.HciHimSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.himsearch.HciHimSearchServiceResult
import de.jlnstrk.transit.client.hci.model.him.HciHimFilter
import de.jlnstrk.transit.client.hci.model.him.HciHimFilterMode
import de.jlnstrk.transit.client.hci.model.him.HciHimFilterType
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.MessageListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StatusInformationResult
import de.jlnstrk.transit.common.service.StatusInformationService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon

internal class HciStatusInformationService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), StatusInformationService {
    override val supportsFilterPriorities: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsFilterLines: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

    override suspend fun statusInformation(
        filterPriorities: Set<Message.Priority>?,
        filterProducts: Set<ProductClass>?,
        filterLines: LineSet?,
        maxResults: Int?
    ): StatusInformationResult {
        val himFilters = mutableListOf<HciHimFilter>()
        filterProducts?.let {
            himFilters.add(
                HciHimFilter(
                    type = HciHimFilterType.PROD,
                    mode = HciHimFilterMode.INC,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val hciRequest = HciHimSearchServiceRequest {
            maxNum = maxResults
            himFltrL = himFilters
        }
        try {
            val hciResponse =
                consumer.serviceRequest<HciHimSearchServiceResult>(hciRequest) ?: return ServiceResult.noResult()
            if (hciResponse.msgL.isEmpty()) {
                return ServiceResult.noResult()
            }
            return withCommon(hciResponse.common!!) {
                val response = MessageListData(
                    header = DataHeader(),
                    messages = hciResponse.msgL.map { it.asCommon(this) },
                    scrollContext = null,
                )
                ServiceResult.success(response)
            }
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    else -> null
                }, e.message
            )
        }
    }
}