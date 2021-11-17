package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.himsearch.HciHimSearchRequest
import de.jlnstrk.transit.api.hci.request.filter.HciHimFilter
import de.jlnstrk.transit.api.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.util.model.LineSet
import de.jlnstrk.transit.util.model.Message
import de.jlnstrk.transit.util.model.ProductClass
import de.jlnstrk.transit.util.response.StatusInformationData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.StatusInformationResult
import de.jlnstrk.transit.util.service.StatusInformationService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.HciInteropService

internal class HciStatusInformationService(
    provider: HciProvider,
    endpoint: HciConsumer
) : HciInteropService(provider, endpoint), StatusInformationService {
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
                    type = HciHimFilter.Type.PROD,
                    mode = HciRequestFilterMode.INCLUSIVE,
                    value = provider.setToBitmask(it).toString()
                )
            )
        }
        val hciRequest = HciHimSearchRequest {
            maxNum = maxResults
            himFltrL = himFilters
        }
        try {
            val hciResponse = endpoint.serviceRequest(hciRequest) ?: return ServiceResult.noResult()
            if (hciResponse.msgL.isEmpty()) {
                return ServiceResult.noResult()
            }
            return withCommon(hciResponse.common) {
                val response = StatusInformationData(hciResponse.msgL.map(::convertHim))
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