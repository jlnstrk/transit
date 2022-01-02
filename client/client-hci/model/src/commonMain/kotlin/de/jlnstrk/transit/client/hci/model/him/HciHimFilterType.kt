package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciHimFilterType {
  ADMIN,
  CAT,
  CH,
  COMP,
  DEPT,
  EID,
  HIMCAT,
  HIMID,
  HIMTAG,
  LINE,
  LINEID,
  META,
  OPR,
  PID,
  PROD,
  REG,
  SENDER,
  SRC,
  STATION,
  TRAIN,
  TXT,
  UIC,
}
