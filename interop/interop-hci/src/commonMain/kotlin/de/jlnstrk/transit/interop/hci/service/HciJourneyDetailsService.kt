package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.journeydetails.HciJourneyDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.journeydetails.HciJourneyDetailsServiceResult
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Journey
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.response.JourneyDetailsData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.JourneyDetailsResult
import de.jlnstrk.transit.common.service.JourneyDetailsService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon
import de.jlnstrk.transit.interop.hci.conversion.asHci

internal class HciJourneyDetailsService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), JourneyDetailsService {
    override val supportsStartIndex: Boolean get() = true
    override val supportsStartLocation: Boolean get() = true
    override val supportsEndIndex: Boolean get() = true
    override val supportsEndLocation: Boolean get() = true
    override val supportsIncludeStops: Boolean get() = true
    override val supportsIncludePassedStops: Boolean get() = true
    override val supportsIncludePolyline: Boolean get() = true
    override val supportsIncludeComposition: Boolean get() = true

    override suspend fun journeyDetails(
        journey: Journey,
        startIndex: Int?,
        startLocation: Location?,
        endIndex: Int?,
        endLocation: Location?,
        includeStops: Boolean?,
        includePassedStops: Boolean?,
        includePolyline: Boolean?,
        includeComposition: Boolean?
    ): JourneyDetailsResult {
        val hciRequest = HciJourneyDetailsServiceRequest {
            jid = journey.id

            dIdx = startIndex
            dLoc = startLocation?.asHci()
            aIdx = endIndex
            aLoc = endLocation?.asHci()

            getAnnotations = true
            getPasslist = includePassedStops
            getPolyline = includePolyline
            getTrainComposition = includeComposition
            getSimpleTrainComposition = includeComposition
            polySplitting = false
        }
        try {
            val hciResponse = consumer.serviceRequest<HciJourneyDetailsServiceResult>(hciRequest) ?: return ServiceResult.noResult()
            return withCommon(hciResponse.common ?: return ServiceResult.noResult()) {
                val response = JourneyDetailsData(
                    header = DataHeader(
                        calculationTime = null,
                        // realtimeReference = hciResponse.planrtTS,
                        globalMessages = hciResponse.globMsgL
                            .mapNotNull(HciMessage::himX)
                            .map(messages::get),
                        globalAttributes = hciResponse.globMsgL
                            .mapNotNull(HciMessage::remX)
                            .map(attributes::get),
                    ),
                    journey = hciResponse.journey!!.asCommon(this, null),
                )
                ServiceResult.success(response)
            }
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(
                e, when (e) {
                    is HciException.Service -> when (e.serviceError) {
                        else -> null
                    }
                    else -> null
                }, e.message
            )
        }
    }
}