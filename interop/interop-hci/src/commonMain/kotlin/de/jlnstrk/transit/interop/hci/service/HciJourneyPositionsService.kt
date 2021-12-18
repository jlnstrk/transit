package de.jlnstrk.transit.interop.hci.service

import de.jlnstrk.transit.client.hci.HciConsumer
import de.jlnstrk.transit.client.hci.HciException
import de.jlnstrk.transit.client.hci.method.journeygeopos.HciJourneyGeoPosRequest
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRectangle
import de.jlnstrk.transit.client.hci.model.geo.HciGeoRing
import de.jlnstrk.transit.client.hci.request.filter.HciJourneyFilter
import de.jlnstrk.transit.client.hci.request.filter.HciRequestFilterMode
import de.jlnstrk.transit.common.model.Area
import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.LineSet
import de.jlnstrk.transit.common.model.ProductSet
import de.jlnstrk.transit.common.response.JourneyListData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.JourneyPositionsResult
import de.jlnstrk.transit.common.service.JourneyPositionsService
import de.jlnstrk.transit.interop.hci.HciInteropService
import de.jlnstrk.transit.interop.hci.HciProvider
import de.jlnstrk.transit.interop.hci.conversion.asCommon
import de.jlnstrk.transit.interop.hci.conversion.asHci

internal class HciJourneyPositionsService(
    provider: HciProvider,
    consumer: HciConsumer
) : HciInteropService(provider, consumer), JourneyPositionsService {
    override val supportsBoundingBox: Boolean get() = true
    override val supportsRadius: Boolean get() = true
    override val supportsFilterProducts: Boolean get() = true
    override val supportsFilterLines: Boolean get() = true
    override val supportsMaxResults: Boolean get() = true

    override suspend fun journeyPositions(
        area: Area,
        filterProducts: ProductSet?,
        filterLines: LineSet?,
        maxResults: Int?
    ): JourneyPositionsResult {
        val hciRequest = HciJourneyGeoPosRequest {
            rect = (area as? Area.Rectangle)?.let {
                HciGeoRectangle(
                    llCrd = it.southwest.asHci(),
                    urCrd = it.northeast.asHci(),
                )
            }
            ring = (area as? Area.Radius)?.let {
                HciGeoRing(
                    cCrd = it.center.asHci(),
                    maxDist = it.radius,
                )
            }

            val journeyFilters = mutableListOf<HciJourneyFilter>()
            filterProducts?.let {
                journeyFilters.add(
                    HciJourneyFilter(
                        type = HciJourneyFilter.Type.PROD,
                        mode = HciRequestFilterMode.BIT,
                        value = provider.setToBitmask(it).toString()
                    )
                )
            }
            filterLines?.let {
                // TODO: Line filter
            }
            maxJny = maxResults
        }

        try {
            val hciResponse = consumer.serviceRequest(hciRequest)!!
            val data = withCommon(hciResponse.common) {
                JourneyListData(
                    header = DataHeader(),
                    journeys = hciResponse.jnyL.map { it.asCommon(this, null) },
                    scrollContext = null,
                )
            }
            return ServiceResult.success(data)
        } catch (e: HciException) {
            println(e)
            return ServiceResult.failure(e)
        }
    }
}