package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrMonitorFlags {
  AF,
  ALLATTRF,
  ANSF,
  ARR,
  CF,
  DEP,
  DEP_NO_RT,
  DF,
  DV,
  FF,
  FTF,
  FTFP,
  FTFS,
  INCOMP,
  NDF,
  OF,
  PF,
  PLANF,
  REQATTRF,
  RF,
  SDF,
  TRF,
  WF,
}
