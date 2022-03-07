package de.jlnstrk.transit.client.hci.model.location

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciLocationType {
  A,
  ALL,
  AP,
  C,
  HL,
  LM,
  MCP,
  P,
  S,
  SA,
  SAP,
  SP,
  U,
}
