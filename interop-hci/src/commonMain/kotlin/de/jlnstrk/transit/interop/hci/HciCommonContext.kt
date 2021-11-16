package de.jlnstrk.transit.interop.hci

import com.soywiz.klock.days
import com.soywiz.klock.plus
import de.jlnstrk.transit.api.hci.model.*
import de.jlnstrk.transit.api.hci.model.connection.HciConnection
import de.jlnstrk.transit.api.hci.model.gis.HciGis
import de.jlnstrk.transit.api.hci.model.him.HciHimMessage
import de.jlnstrk.transit.api.hci.model.journey.HciJourney
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import de.jlnstrk.transit.interop.hci.extensions.asCommon
import de.jlnstrk.transit.interop.hci.extensions.decodeGpa
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalDateTime
import de.jlnstrk.transit.util.extensions.computeIfAbsent
import de.jlnstrk.transit.util.extensions.toLineSet
import de.jlnstrk.transit.util.extensions.toProductSet
import de.jlnstrk.transit.util.model.*
import de.jlnstrk.transit.util.model.stop.Stop

internal class HciCommonContext(
    private val provider: HciProvider,
    private val common: HciCommon
) {
    private val locations: Array<Location?> = arrayOfNulls(common.locL.size)
    private val lines: Array<Line?> = arrayOfNulls(common.prodL.size)
    private val operators: Array<String?> = arrayOfNulls(common.opL.size)
    private val polylines: Array<Polyline?> = arrayOfNulls(common.polyL.size)
    private val messages: Array<Message?> = arrayOfNulls(common.himL.size)
    private val attributes: Array<Attribute?> = arrayOfNulls(common.remL.size)

    fun getOrConvertLocation(index: Int): Location =
        locations.computeIfAbsent(common.locL, index, ::convertLocation)

    fun getOrConvertLine(index: Int): Line =
        lines.computeIfAbsent(common.prodL, index, ::convertProduct)

    fun getOrConvertMessage(index: Int): Message =
        messages.computeIfAbsent(common.himL, index, ::convertHim)

    fun getOrConvertAttribute(index: Int): Attribute =
        attributes.computeIfAbsent(common.remL, index, ::convertRemark)

    fun getOrConvertPolyline(index: Int): Polyline =
        polylines.computeIfAbsent(common.polyL, index, ::convertPolyline)

    fun convertSection(source: HciSection, date: LocalDate): Leg? {
        return when {
            source is HciSection.Journey -> Leg.Public(
                departure = convertDeparture(source.departure, date),
                arrival = convertArrival(source.arrival, date),
                journey = convertJourney(source.jny, date),
                alternatives = source.jny.freq?.jnyL?.map {
                    convertJourney(
                        it,
                        date
                    )
                },
                frequency = source.jny.freq?.let(::convertFrequency)
            )
            source is HciSection.Transfer -> null
            /*Leg.Transfer(
                departure = convertDeparture(source.departure, date),
                arrival = convertArrival(source.arrival, date)
            )*/
            else -> Leg.Individual(
                departure = convertDeparture(source.departure, date),
                arrival = convertArrival(source.arrival, date),
                type = when (source) {
                    is HciSection.Walk -> Leg.Individual.Type.WALK
                    is HciSection.Bike -> Leg.Individual.Type.BIKE
                    is HciSection.Kiss -> Leg.Individual.Type.CAR
                    is HciSection.Taxi -> Leg.Individual.Type.TAXI
                    else -> throw IllegalStateException()
                },
                gis = when (source) {
                    is HciSection.Walk -> convertGis(source.gis)
                    is HciSection.Bike -> convertGis(source.gis)
                    is HciSection.Kiss -> convertGis(source.gis)
                    is HciSection.Taxi -> convertGis(source.gis)
                    else -> throw IllegalStateException()
                }
            )
        }
    }

    fun convertConnection(connection: HciConnection): Trip {
        return Trip(
            literalId = connection.ctxRecon,
            numericId = connection.ctxRecon.hashCode().toLong(),
            departure = convertDeparture(connection.dep, connection.date),
            arrival = convertArrival(connection.arr, connection.date),
            legs = connection.secL.mapNotNull {
                convertSection(
                    it,
                    connection.date
                )
            },
            isRideable = connection.isNotRdbl != true,
            frequency = connection.freq?.let(::convertFrequency),
            schedule = null
        )
    }

    fun convertGis(source: HciGis): Gis {
        return Gis(
            distance = source.dist,
            duration = source.durS
        )
    }

    fun convertFrequency(source: HciFrequency): Frequency {
        return Frequency(
            minWaitTime = source.minC,
            maxWaitTime = source.maxC,
            numAlternatives = source.numC
        )
    }

    fun convertJourney(source: HciJourney, tripDate: LocalDate?): Journey {
        val attributes = source.msgL
            .mapNotNull(HciMessage::remX)
            .map(::getOrConvertAttribute)
        val messages = source.msgL
            .mapNotNull(HciMessage::himX)
            .map(::getOrConvertMessage)
        return Journey(
            literalId = source.jid,
            numericId = source.jid.hashCode().toLong(),
            line = getOrConvertLine(source.prodX),
            directionTo = Location.Station(source.dirTxt).also {
                provider.normalizeLocation(it)
            },
            stop = convertStop(
                source.stbStop ?: source.stopL.first(),
                source.date ?: tripDate!!
            ),
            stops = source.stopL.map {
                convertStop(it, source.date ?: tripDate!!)
            },
            messages = messages,
            attributes = attributes,
            polyline = source.polyG?.polyXL?.first()?.let(::getOrConvertPolyline),
            isReachable = source.isRchbl,
            isCancelled = source.isCncl,
            isPartiallyCancelled = source.isPartCncl
        )
    }

    fun convertProduct(source: HciProduct): Line {
        return Line(
            product = source.cls?.let(provider::singleFromClass) ?: Means.OTHER,
            label = source.prodCtx?.line ?: source.name,
            id = source.prodCtx?.lineId ?: source.pid,
            name = source.name,
            shortName = source.nameS,
            number = source.prodCtx?.num ?: source.number,
            operator = source.oprX?.let(common.opL::getOrNull)?.name,
            admin = source.prodCtx?.admin
        ).also {
            provider.normalizeLine(it)
        }
    }

    fun convertLocation(source: HciLocation): Location {
        return when (source.type) {
            HciLocation.Type.STATION -> Location.Station(
                literalId = source.lid,
                numericId = source.extId ?: 0L,
                name = source.name,
                coordinates = source.crd?.asCommon(),
                products = source.pCls?.let(provider::setFromBitmask)?.toProductSet(),
                lines = source.pRefL
                    .map(::getOrConvertLine)
                    .toLineSet(),
                weight = source.wt,
                isSubStation = source.isMainMast == false || source.mMastLocX != null
            )
            HciLocation.Type.ADDRESS -> Location.Address(
                literalId = source.lid,
                numericId = source.lid.hashCode().toLong(),
                name = source.name,
                coordinates = source.crd?.asCommon()
            )
            HciLocation.Type.POI -> Location.Poi(
                literalId = source.lid,
                numericId = source.lid.hashCode().toLong(),
                name = source.name,
                coordinates = source.crd?.asCommon()
            )
            else -> throw IllegalStateException()
        }.also {
            provider.normalizeLocation(it)
        }
    }

    fun convertHim(source: HciHimMessage): Message {
        return Message(
            head = source.head.orEmpty().ifEmpty { source.lead }.orEmpty(),
            subhead = source.lead,
            body = source.text ?: "",
            validFrom = LocalDateTime(source.sDate, source.sTime)
                .toOffsetUnadjusted(provider.timezone),
            validUntil = LocalDateTime(source.eDate, source.eTime)
                .toOffsetUnadjusted(provider.timezone),
            modified = LocalDateTime(source.lModDate, source.lModTime)
                .toOffsetUnadjusted(provider.timezone),
            priority = when {
                source.prio > 66 -> Message.Priority.HIGH
                source.prio > 33 -> Message.Priority.MEDIUM
                else -> Message.Priority.LOW
            },
            products = provider.setFromBitmask(source.prod),
            lines = source.affProdRefL.map(::getOrConvertLine).toLineSet()
        ).also {
            provider.normalizeMessage(it)
        }
    }

    fun convertRemark(source: HciRemark): Attribute {
        return Attribute(
            name = source.txtS ?: source.txtN.orEmpty()
        )
    }

    fun convertArrival(source: HciStop, date: LocalDate): Stop.Arrival {
        val arrivalTimezone = source.aTZOffset ?: provider.timezone
        return Stop.Arrival(
            location = getOrConvertLocation(source.locX),
            index = source.idx,
            arrivalScheduled = LocalDateTime(
                date.plus((source.aTimeS?.offsetDays?.toLong() ?: 0L).days),
                source.aTimeS!!.time
            ).toOffsetUnadjusted(arrivalTimezone),
            arrivalRealtime = source.aTimeR?.let {
                LocalDateTime(date.plus(it.offsetDays.toLong().days), it.time)
                    .toOffsetUnadjusted(arrivalTimezone)
            },
            arrivalScheduledPlatform = source.aPltfS?.txt ?: source.aPlatfS,
            arrivalRealtimePlatform = source.aPltfR?.txt ?: source.aPlatfR,
            arrivalCancelled = source.aCncl ?: false
        )
    }

    fun convertDeparture(source: HciStop, date: LocalDate): Stop.Departure {
        val departureTimezone = source.dTZOffset ?: provider.timezone
        return Stop.Departure(
            location = getOrConvertLocation(source.locX),
            index = source.idx,
            departureScheduled = LocalDateTime(
                date.plus((source.dTimeS?.offsetDays?.toLong() ?: 0L).days),
                source.dTimeS!!.time
            ).toOffsetUnadjusted(departureTimezone),
            departureRealtime = source.dTimeR?.let {
                LocalDateTime(
                    date.plus(it.offsetDays.toLong().days),
                    it.time
                ).toOffsetUnadjusted(departureTimezone)
            },
            departureScheduledPlatform = source.dPltfS?.txt ?: source.dPlatfS,
            departureRealtimePlatform = source.dPltfR?.txt ?: source.dPlatfR,
            departureCancelled = source.dCncl ?: false
        )
    }

    fun convertIntermediate(source: HciStop, date: LocalDate): Stop.Intermediate {
        val arrivalTimezone = source.aTZOffset ?: provider.timezone
        val departureTimezone = source.dTZOffset ?: provider.timezone
        return Stop.Intermediate(
            location = getOrConvertLocation(source.locX),
            index = source.idx,
            arrivalScheduled = LocalDateTime(
                date.plus((source.aTimeS?.offsetDays?.toLong() ?: 0L).days),
                source.aTimeS!!.time
            ).toOffsetUnadjusted(arrivalTimezone),
            arrivalRealtime = source.aTimeR?.let {
                LocalDateTime(date.plus(it.offsetDays.toLong().days), it.time)
                    .toOffsetUnadjusted(arrivalTimezone)
            },
            arrivalScheduledPlatform = source.aPltfS?.txt ?: source.aPlatfS,
            arrivalRealtimePlatform = source.aPltfR?.txt ?: source.aPlatfR,
            arrivalCancelled = source.aCncl ?: false,
            departureScheduled = LocalDateTime(
                date.plus((source.dTimeS?.offsetDays?.toLong() ?: 0L).days),
                source.dTimeS!!.time
            ).toOffsetUnadjusted(departureTimezone),
            departureRealtime = source.dTimeR?.let {
                LocalDateTime(
                    date.plus(it.offsetDays.toLong().days),
                    it.time
                ).toOffsetUnadjusted(departureTimezone)
            },
            departureScheduledPlatform = source.dPltfS?.txt ?: source.dPlatfS,
            departureRealtimePlatform = source.dPltfR?.txt ?: source.dPlatfR,
            departureCancelled = source.dCncl ?: false
        )
    }

    fun convertStop(source: HciStop, date: LocalDate): Stop {
        return when {
            source.aTimeS != null && source.dTimeS != null -> convertIntermediate(
                source,
                date
            )
            source.aTimeS != null -> convertArrival(source, date)
            source.dTimeS != null -> convertDeparture(source, date)
            else -> Stop.Passing(
                location = getOrConvertLocation(source.locX),
                index = source.idx
            )
        }
    }

    fun convertPolyline(source: HciPolyline): Polyline {
        var commonPoints: List<Coordinates>? = null
        when {
            source.crd.isNotEmpty() -> {
                commonPoints = ArrayList(source.crd.size / source.dim)
                var i = 0
                while (i < source.crd.size) {
                    val lat = source.crd[i++]
                    val lon = source.crd[i++]
                    var alt = Double.NaN
                    if (source.dim == 3) {
                        alt = source.crd[i++]
                    }
                    commonPoints.add(Coordinates(lat, lon, alt))
                }
            }
            source.crdEncYX != null -> {
                commonPoints = source.crdEncYX!!.decodeGpa()
            }
        }
        val commonMarkers = source.ppLocRefL.map {
            Polyline.Marker(
                index = it.ppIdx,
                location = getOrConvertLocation(it.locX)
            )

        }
        return Polyline(commonPoints.orEmpty(), commonMarkers)
    }
}