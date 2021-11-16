package de.jlnstrk.transit.api.hci.method.locmatch

import de.jlnstrk.transit.api.hci.config.HciCompat
import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.model.location.HciLocationInput
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.request.filter.HciLocationFilter
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocMatchRequest(
    /** The request input */
    public var input: HciLocationInput,
    /** The data source to match against */
    public var dts: DataSource? = null,
    /** Whether products of locations shall be returned */
    @field:HciCompat(unsafeUntilAtLeast = "1.18", safeFromAtLeast = "1.34")
    public var getProducts: Boolean? = null,
    /** The country to match locations of */
    public var cntry: String? = null,
    /** Specifies filters to be applied on the returned locations */
    public var locFltrL: List<HciLocationFilter> = emptyList(),
) : HciServiceRequest<HciLocMatchResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.LOC_MATCH

    public companion object {
        public inline operator fun invoke(
            input: HciLocationInput,
            init: HciLocMatchRequest.() -> Unit
        ): HciLocMatchRequest =
            HciLocMatchRequest(input).apply(init)
    }

    @HciModel("1.39")
    @Serializable
    public enum class DataSource {
        // TODO: Meaning?
        GS,

        // TODO: Meaning?
        PSF,
    }
}