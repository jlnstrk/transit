package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciCoreError {
  AUTH,
  CLIENTVERSION,
  ERROR,
  GRAPH,
  HAMM,
  HAMM_LOAD,
  MEMORY,
  NULLPTR,
  OK,
  PARSE,
  SUB_GRAPH,
  VERSION,
  VIEW,
  WRITE,
}
