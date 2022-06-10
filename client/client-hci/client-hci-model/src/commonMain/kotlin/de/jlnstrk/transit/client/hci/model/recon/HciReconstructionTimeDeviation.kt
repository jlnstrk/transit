package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionTimeDeviation(
  public val arrL: Int = 0,
  public val arrU: Int = 0,
  public val depL: Int = 0,
  public val depU: Int = 0,
)
