@file:UseSerializers(
    HapiZoneOffsetSerializer::class
)

package de.jlnstrk.transit.api.hapi.model.location

import de.jlnstrk.transit.api.hafas.HapiXsd
import de.jlnstrk.transit.api.hapi.model.HapiMessage
import de.jlnstrk.transit.api.hapi.model.HapiProduct
import de.jlnstrk.transit.api.hapi.model.HapiResourceLink
import de.jlnstrk.transit.api.hapi.model.tariff.HapiTariffResult
import de.jlnstrk.transit.api.hapi.serializer.HapiListUnwrapSerializer
import de.jlnstrk.transit.api.hapi.serializer.HapiZoneOffsetSerializer
import de.jlnstrk.transit.util.ZoneOffset
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/** The element StopLocation specifies a stop/station in a result of a location request. */
@HapiXsd("1.29")
@Serializable
public data class HapiStopLocation(
    /** This ID can either be used as originId or destId to perform a trip request
     * or to call a departure or arrival board. */
    public val id: String,
    /** This ID defines an alternative ID for this stop location
     * and can not be used to perform further requests. */
    public val extId: String,
    /** True if this stop belongs to a main mast. */
    public val hasMainMast: Boolean?,
    /** ID of the main mast this stop belongs to. */
    public val mainMastId: String?,
    /** External ID of the main mast this stop belongs to. */
    public val mainMastExtId: String?,
    /** Contains the output name of this stop or station */
    public val name: String,
    /** The WGS84 longitude of the geographical position of the stop/station. */
    public val lon: Double?,
    /** The WGS84 latitude of the geographical position of the stop/station. */
    public val lat: Double?,
    /** Track information, if available. */
    public val track: String?,
    /** This value specifies some kind of importance of this stop. The more traffic at this stop the higher the weight.
     * The range is between 0 and 32767. This attribute is only available in the location.allstops response */
    public val weight: Int?,
    /** This value specifies the distance to the given coordinate if called by a nearby search request. */
    public val dist: Int?,
    /** This value specifies the products available at this location. */
    public val products: Int?,
    /** True, if the stop is a meta stop. */
    public val meta: Boolean = false,
    /** True, if the stop is not resolved fully and could be refined. */
    public val refinable: Boolean = false,
    /** A percentage value [0, 100] indicating how well the name of the given location matches the input location name.
     * This attribute is only available in the location.name response */
    public val matchValue: Int?,
    /** True, if the stop is an entry point. */
    public val entry: Boolean?,
    /** Contains a list of notes to be displayed for this location, like attributes or footnotes. */
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val LocationNotes: List<HapiLocationNote> = emptyList(),
    @Serializable(with = HapiListUnwrapSerializer::class)
    public val Message: List<HapiMessage> = emptyList(),
    /** Products running at this stop. */
    public val productAtStop: List<HapiProduct> = emptyList(),
    public val TariffResult: HapiTariffResult?,
    public val links: List<HapiResourceLink> = emptyList(),
    public val altId: List<String> = emptyList(),
    public val mainMastAltId: List<String> = emptyList(),
    public val timezoneOffset: ZoneOffset?,
) : HapiStopOrCoordLocation