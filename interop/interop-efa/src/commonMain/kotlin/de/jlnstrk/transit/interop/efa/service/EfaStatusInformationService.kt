package de.jlnstrk.transit.interop.efa.service

import de.jlnstrk.transit.client.efa.EfaClient
import de.jlnstrk.transit.client.efa.endpoint.addinfo.EfaAddInfoResponse
import de.jlnstrk.transit.client.efa.model.EfaTravelInfo
import de.jlnstrk.transit.client.efa.util.efaAddInfoRequest
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.common.response.MessageListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StatusInformationResult
import de.jlnstrk.transit.common.service.StatusInformationService
import de.jlnstrk.transit.interop.efa.EfaProvider
import de.jlnstrk.transit.interop.efa.EfaService
import de.jlnstrk.transit.interop.efa.normalization.generic.normalize
import de.jlnstrk.transit.util.OffsetDateTime

internal class EfaStatusInformationService(
    provider: EfaProvider,
    client: EfaClient
) : EfaService(provider, client), StatusInformationService {
    override val supportsFilterPriorities: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsFilterLines: Boolean get() = true

    override suspend fun statusInformation(
        filterPriorities: Set<Message.Priority>?,
        filterProducts: Set<ProductClass>?,
        filterLines: LineSet?,
        maxResults: Int?
    ): StatusInformationResult {
        try {
            val efaRequest = efaAddInfoRequest {
                filterPublicationStatus =
                    EfaAddInfoResponse.AdditionalInfo.PublicationStatus.CURRENT

                val today = OffsetDateTime.nowLocal()
                    .toOffset(provider.timezone)
                    .local.date
                filterValidIntervalStart = today

                filterInfoType = setOf(
                    EfaTravelInfo.Type.LINE_INFO,
                    EfaTravelInfo.Type.LINE_BLOCKING,
                    EfaTravelInfo.Type.STOP_INFO,
                    EfaTravelInfo.Type.STOP_BLOCKING,
                )

                if (filterProducts != null) {
                    filterMOTType = provider.denormalizeEfaMeans(filterProducts)
                }
            }

            val efaResponse = client.xmlAddInfoRequest(efaRequest)
            val response = with(provider) {
                MessageListData(
                    header = DataHeader(),
                    messages = efaResponse.additionalInformation.travelInformations.first().travelInformation
                        .map { it.normalize(provider) },
                    scrollContext = null,
                )
            }
            return ServiceResult.success(response)
        } catch (e: Exception) {
            return ServiceResult.failure(e, message = e.message)
        }
    }

}