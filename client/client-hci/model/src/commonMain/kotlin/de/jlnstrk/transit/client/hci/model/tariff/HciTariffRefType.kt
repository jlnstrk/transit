package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciTariffRefType {
  F,
  FS,
  T,
}
