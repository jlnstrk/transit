package de.jlnstrk.transit.client.hapi.model.location

import de.jlnstrk.transit.client.hafas.HapiXsd
import de.jlnstrk.transit.client.hapi.model.HapiIcon
import de.jlnstrk.transit.client.hapi.model.HapiResourceLink
import de.jlnstrk.transit.client.hapi.serializer.HapiListUnwrapSerializer
import kotlinx.serialization.Serializable

/** The element CoordLocation specifies a coordinate based location in a result of a location request.
 * It contains an output name, latitude, longitude and a type (address or point of interest).
 * The coordinates and the name can be used as origin or destination parameters to perform a trip request. */
@HapiXsd("1.29")
@Serializable
public data class HapiCoordLocation(
    /** This optional ID can either be used as originId or destId to perform a trip request. */
    public val id: String?,
    /** This ID defines an alternative ID for this stop location and can not be used to perform further requests. */
    public val extId: String?,
    /** Contains the output name of the address or point of interest */
    public val name: String,
    /** The attribute type specifies the type of location.
     * Valid values are ADR (address), POI (point of interest), CRD (coordinate),
     * MCP (mode change point) or HL (hailing point). */
    public val type: HapiLocationType,
    /** The WGS84 longitude of the geographical position of the stop/station. */
    public val lon: Double?,
    /** The WGS84 latitude of the geographical position of the stop/station. */
    public val lat: Double?,
    /** This value specifies the distance to the given coordinate if called by a nearby search request. */
    public val dist: Int?,
    /** True, if the stop is not resolved fully and could be refined. */
    public val refinable: Boolean = false,
    /** A percentage value [0, 100] indicating how well the name of the given location matches the input location name.
     * This attribute is only available in the location.name response */
    public val matchValue: Int?,
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val LocationNotes: List<HapiLocationNote> = emptyList(),
    @Serializable(with = HapiListUnwrapSerializer.DoubleNested::class)
    public val links: List<HapiResourceLink> = emptyList(),
    public val icon: HapiIcon?,
) : HapiStopOrCoordLocation