package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.api.hci.HciConsumer
import de.jlnstrk.transit.api.hci.HciException
import de.jlnstrk.transit.api.hci.method.reconstruction.HciReconstructionRequest
import de.jlnstrk.transit.api.hci.model.recon.HciReconstruction
import de.jlnstrk.transit.util.model.Trip
import de.jlnstrk.transit.util.response.TripRefreshData
import de.jlnstrk.transit.util.response.base.ServiceResult
import de.jlnstrk.transit.util.service.TripRefreshResult
import de.jlnstrk.transit.util.service.TripRefreshService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.HciInteropService

internal class HciTripRefreshService(
    provider: HciProvider,
    endpoint: HciConsumer
) : HciInteropService(provider, endpoint), TripRefreshService {

    override suspend fun tripRefresh(
        context: Trip.RefreshContext,
        includeStops: Boolean?,
        includePassedStops: Boolean?,
        includePolylines: Boolean?
    ): TripRefreshResult {
        if (context !is Context) {
            throw IllegalArgumentException()
        }
        val hciRequest = HciReconstructionRequest(
            outReconL = listOf(HciReconstruction(ctx = context.contextReconstruction)),
            getPasslist = includePassedStops,
            getPolyline = includePolylines,
            getIST = true
        )
        try {
            val hciResult = endpoint.serviceRequest(hciRequest) ?: return ServiceResult.noResult()
            val connection =
                hciResult.outConL.firstOrNull() ?: return ServiceResult.noResult()
            return withCommon(hciResult.common) {
                val result = TripRefreshData(
                    trip = convertConnection(connection)
                )
                ServiceResult.success(result)
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

    internal data class Context(
        val contextReconstruction: String
    ) : Trip.RefreshContext

}