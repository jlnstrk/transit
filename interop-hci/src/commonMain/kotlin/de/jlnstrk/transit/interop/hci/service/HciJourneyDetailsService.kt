package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciEndpoint
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.journeydetails.HciJourneyDetailsRequest
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.util.model.Journey
import de.jlnstrk.transit.util.model.Location
import de.jlnstrk.transit.util.response.JourneyDetailsData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.JourneyDetailsResult
import de.jlnstrk.transit.util.service.JourneyDetailsService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.extensions.asHci

internal class HciJourneyDetailsService(
    provider: HciProvider,
    endpoint: HciEndpoint
) : HciInteropService(provider, endpoint), JourneyDetailsService {
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
        val request = HciJourneyDetailsRequest(
            jid = journey.literalId,
            dIdx = startIndex,
            dLoc = startLocation?.asHci(),
            aIdx = endIndex,
            aLoc = endLocation?.asHci(),
            getPasslist = includePassedStops,
            getPolyline = includePolyline,
            getTrainComposition = includeComposition,
            getSimpleTrainComposition = includeComposition,
            polySplitting = false
        )
        try {
            val hciResponse = endpoint.serviceRequest(request) ?: return ServiceResult.noResult()
            return withCommon(hciResponse.common) {
                val direction = Location.Station(name = hciResponse.journey.dirTxt)
                val stops = hciResponse.journey.stopL.map { convertStop(it, hciResponse.journey.date!!) }
                // polyline splitting is OFF
                val polyline = hciResponse.journey.polyG?.polyXL
                    ?.first()
                    ?.let(::getOrConvertPolyline)
                val messages = hciResponse.journey.msgL
                    .mapNotNull(HciMessage::himX)
                    .map(::getOrConvertMessage)
                val attributes = hciResponse.journey.msgL
                    .mapNotNull(HciMessage::remX)
                    .map(::getOrConvertAttribute)
                val response = JourneyDetailsData(
                    direction = direction,
                    line = getOrConvertLine(hciResponse.journey.prodX),
                    stops = stops,
                    polyline = polyline,
                    messages = messages,
                    attributes = attributes,
                    isCancelled = hciResponse.journey.isCncl,
                    isPartiallyCancelled = hciResponse.journey.isPartCncl
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