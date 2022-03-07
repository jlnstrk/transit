package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciLocationNGrammFilterMode {
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
