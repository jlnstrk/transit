package de.jlnstrk.transit.client.hci.model.client

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciClientId {
  ARRIVA,
  AVV_AACHEN,
  BART,
  BVG,
  CDT,
  CFL,
  CMTA,
  DART,
  DB,
  @SerialName("DB-REGIO")
  DB_REGIO,
  @SerialName("DB-REGIO-AVV")
  DB_REGIO_AVV,
  @SerialName("DB-REGIO-BNAV")
  DB_REGIO_BNAV,
  @SerialName("DB-REGIO-MVV")
  DB_REGIO_MVV,
  @SerialName("DB-REGIO-NRW")
  DB_REGIO_NRW,
  @SerialName("DB-REGIO-VGN")
  DB_REGIO_VGN,
  @SerialName("DB-REGIO-VRN")
  DB_REGIO_VRN,
  @SerialName("DB-REGIO-VRS")
  DB_REGIO_VRS,
  @SerialName("DB-REGIO-VVO")
  DB_REGIO_VVO,
  @SerialName("DB-REGIO-VVS")
  DB_REGIO_VVS,
  @SerialName("DB-UK-WEBTIS")
  DB_UK_WEBTIS,
  @SerialName("DB-VENDO")
  DB_VENDO,
  DBZUGRADARNETZ,
  DELFIPLUS,
  DK,
  DSB,
  DUBAI,
  ECONNECT,
  EMMA,
  FEDA,
  HAFAS,
  HAPP,
  HVV,
  INVG,
  IRISHRAIL,
  JTMT,
  LOROL,
  MMILUX,
  MOOBILPLUS,
  NAHSH,
  NASA,
  NOKIA,
  NRI,
  NSB,
  NVV,
  NYC_HB,
  NYC_WW,
  OEBB,
  POSTAUTO,
  RMV,
  @SerialName("RMV-NAMO")
  RMV_NAMO,
  RSAG,
  SAMTRAFIKEN,
  SBB,
  @SerialName("SBB-HAP")
  SBB_HAP,
  @SerialName("SBB-ZPS")
  SBB_ZPS,
  SITKOL,
  SL,
  SNCB,
  SNCF,
  SNCF_LIVEMAP,
  SWO,
  S_BAHN_BERLIN,
  TRAFIKEN,
  TURKU,
  TWMETRO,
  VAO,
  VASTTRAFIK,
  VBB,
  VBN,
  VBZ,
  VEJ,
  VGB,
  VMT,
  VOR,
  VSN,
  VVW,
  @SerialName("ZPS-SAAR")
  ZPS_SAAR,
  ZVV,
}
