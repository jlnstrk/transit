package de.jlnstrk.transit.api.hci.model.location

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.request.filter.HciLocationFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationInput(
    // TODO: Purpose?
    public val field: HciLocationField,
    /** The location to be matched */
    public val loc: HciLocation,
    /** Additional filters to be applied */
    public val locFltrL: List<HciLocationFilter> = emptyList(),
    /** The maximum number of locations to be returned */
    public val maxLoc: Int? = null,
    /** The provider context for this input */
    public val prvCtx: String? = null,
)