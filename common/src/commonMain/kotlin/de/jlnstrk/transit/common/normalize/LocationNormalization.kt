package de.jlnstrk.transit.common.normalize

import de.jlnstrk.transit.common.model.Location

public interface LocationNormalization {

    public fun normalizeLocation(location: Location): Location {
        val nameAndPlace = normalizeNameAndPlace(location)

        return when (location) {
            is Location.Address -> normalizeAddress(location)
                .let {
                    it.copy(
                        name = nameAndPlace?.name ?: it.name,
                        place = nameAndPlace?.place ?: it.place
                    )
                }
            is Location.Place -> normalizePlace(location)
                .let {
                    it.copy(
                        name = nameAndPlace?.name ?: it.name,
                        place = nameAndPlace?.place ?: it.place
                    )
                }
            is Location.Poi -> normalizePoi(location)
                .let {
                    it.copy(
                        name = nameAndPlace?.name ?: it.name,
                        place = nameAndPlace?.place ?: it.place
                    )
                }
            is Location.Point -> normalizePoint(location)
            is Location.Reference -> normalizeReference(location)
                .let {
                    it.copy(
                        name = nameAndPlace?.name ?: it.name,
                        place = nameAndPlace?.place ?: it.place
                    )
                }
            is Location.Station -> normalizeStation(location)
                .let {
                    it.copy(
                        name = nameAndPlace?.name ?: it.name,
                        place = nameAndPlace?.place ?: it.place
                    )
                }
        }
    }

    public fun normalizeNameAndPlace(location: Location): NameAndPlace? = null

    public fun normalizeAddress(address: Location.Address): Location.Address = address

    public fun normalizePlace(place: Location.Place): Location.Place = place

    public fun normalizePoi(poi: Location.Poi): Location.Poi = poi

    public fun normalizePoint(point: Location.Point): Location.Point = point

    public fun normalizeReference(reference: Location.Reference): Location.Reference = reference

    public fun normalizeStation(station: Location.Station): Location.Station = station
}

public data class NameAndPlace(
    public var name: String,
    public var place: String? = null
)