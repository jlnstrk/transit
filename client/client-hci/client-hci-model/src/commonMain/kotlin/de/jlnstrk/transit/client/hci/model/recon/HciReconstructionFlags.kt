package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstructionFlags(
  public val acceptGaps: Boolean = true,
  public val allowDisabledStops: Boolean = false,
  public val allowDummySections: Boolean = false,
  public val enableLinkedFootpaths: Boolean = false,
  public val enableRtFullSearch: Boolean = false,
  public val filterFootpaths: Boolean = false,
  public val flagAllNonReachable: Boolean = false,
  public val ignoreTimes: Boolean = false,
  public val matchCatStrict: Boolean = true,
  public val matchIdNonBlank: Boolean = true,
  public val matchIdStrict: Boolean = false,
  public val matchNumStrict: Boolean = true,
  public val matchRtType: Boolean = false,
  public val replaceWithDetours: Boolean = false,
)
