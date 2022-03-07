package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciRTMode {
  ATR_DIREKT_RTF,
  ATR_RTF_ZZ_VOLL,
  ATR_VOLL,
  ATR_VOLL_IMMER,
  ATR_VOLL_IMMER_OW,
  ATR_ZZ_VOLL_OW,
  DIREKT,
  DIREKT_RTF,
  FULL,
  HYBRID,
  INFOS,
  INFOS_FT,
  INFOS_NO_DLIMIT,
  INFOS_OHNE_RTF,
  INFOS_REF,
  NUR_RTF,
  OFF,
  OHNE_AKT_DEAKT,
  REALTIME,
  REF_IST,
  REF_VOLL,
  REF_VOLL_IMMER,
  REKONSTRUKTION,
  RTF_ZZ_DIREKT,
  SERVER_DEFAULT,
  TEIL,
  VOLL_IMMER,
  VOLL_OHNE_W,
  ZZ_DIREKT,
  ZZ_DIREKT_RTF,
  ZZ_VOLL,
  ZZ_VOLL_OHNE_W,
}
