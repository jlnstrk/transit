package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciLocationFilterType {
  ATTRL,
  ATTRP,
  INFOTEXT,
  LID,
  META,
  NGR,
  PLATF,
  PROD,
  ROUP_A,
  ROUP_N,
  ROUP_S,
  ROUP_V,
  ROUP_Z,
  ROUS_A,
  ROUS_N,
  ROUS_S,
  ROUS_V,
  ROUS_Z,
  ROU_A,
  ROU_N,
  ROU_S,
  ROU_V,
  ROU_Z,
  SLCTP_A,
  SLCTP_N,
  SLCTP_S,
  SLCTP_V,
  SLCTP_Z,
  SLCTS_A,
  SLCTS_N,
  SLCTS_S,
  SLCTS_V,
  SLCTS_Z,
  SLCT_A,
  SLCT_N,
  SLCT_S,
  SLCT_V,
  SLCT_Z,
}
