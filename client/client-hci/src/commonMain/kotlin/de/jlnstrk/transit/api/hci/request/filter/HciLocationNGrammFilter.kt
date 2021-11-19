package de.jlnstrk.transit.api.hci.request.filter

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciLocationNGrammFilter(
    public val mode: Mode,
    public val crd: HciLocation? = null,
    public val startIds: String? = null,
    public val endIds: String? = null,
    public val fTxt: String? = null,
    public val prefix: String? = null,
    public val attr: String? = null,
    public val maxDist: Int? = null,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Mode {
        DIST_ATTR,
        DIST_INFO,
        DIST_PERI,
        DIST_PERI_REQ,
        DIST_RNG,
        DIST_STNR,
        DIST_STNR_PREF,
        EXCL_ATTR,
        EXCL_INFO,
        EXCL_META,
        EXCL_PERI,
        EXCL_PERI_REQ,
        EXCL_RNG,
        EXCL_STNR,
        EXCL_STNR_PREF,
        ONLY_META,
        SLCT_ATTR,
        SLCT_INFO,
        SLCT_PERI,
        SLCT_PERI_REQ,
        SLCT_PROD,
        SLCT_RNG,
        SLCT_STNR,
        SLCT_STNR_PREF,
    }
}