package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionSettings(
  public val flags: HciReconstructionFlags? = null,
  public val times: HciReconstructionTimeDeviation? = null,
  public val useCombinedComparison: Boolean = true
)
