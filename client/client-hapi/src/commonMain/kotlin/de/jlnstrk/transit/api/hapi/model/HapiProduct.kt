package de.jlnstrk.transit.api.hapi.model

import de.jlnstrk.transit.api.hafas.HapiXsd
import kotlinx.serialization.Serializable

/** Product context, provides access to internal data. For the product category attributes,
 * their assignments are defined in the "zugart" file from the raw Hafas plan data. */
@HapiXsd("1.29")
@Serializable
public data class HapiProduct(
    /** Product name for display. The name might be composed from product number, line and/or category.
     * This is customer specific. */
    public val name: String?,
    /** Internal product name. Not used for display. Used e.g. in reconstruction services. */
    public val internalName: String?,
    /** Additional product name. This is customer specific. */
    public val addName: String?,
    /** Number for display */
    public val displayNumber: String?,
    /** Internal product number (e.g. train number) */
    public val num: String?,
    /** Line name if available (e.g. "R10") */
    public val line: String?,
    /** External line id for use in further requests */
    public val lineId: String?,
    /** Product category name as used for display in standard form. */
    public val catOut: String?,
    /** Internal product category name. */
    public val catIn: String?,
    /** Product category code. */
    public val catCode: String?,
    /** Product category in decimal form. */
    public val cls: Int?,
    /** Product category name for display in short form. */
    public val catOutS: String?,
    /** Product category name for display in long form. */
    public val catOutL: String?,
    /** The operator code. */
    public val operatorCode: String?,
    /** The operator name. */
    public val operator: String?,
    /** The administration name. */
    public val admin: String?,
    /** Defines the first stop/station where this name is valid. See the Stops list for details of the stop/station. */
    public val routeIdxFrom: Int?,
    /** Defines the last stop/station where this name is valid. See the Stops list for details of the stop/station. */
    public val routeIdxTo: Int?,
    /** The match ID. */
    public val matchId: String?,
    public val icon: HapiIcon?,
    public val status: Status?,
) {

    @Serializable
    public data class Status(
        public val code: Int?,
        public val txt: String?,
        public val icon: HapiIcon?,
        public val rtIcon: HapiIcon?,
    )
}