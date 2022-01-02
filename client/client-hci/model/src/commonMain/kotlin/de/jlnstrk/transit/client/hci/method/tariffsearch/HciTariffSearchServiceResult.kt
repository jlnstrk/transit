package de.jlnstrk.transit.client.hci.method.tariffsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.tariff.HciTariffResult
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciTariffSearchServiceResult(
  public val trfRes: HciTariffResult? = null
) : HciServiceResult()
