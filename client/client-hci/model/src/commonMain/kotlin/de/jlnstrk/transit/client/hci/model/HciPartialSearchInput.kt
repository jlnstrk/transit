package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciPartialSearchInput(
  public val replacementSearch: HciPartialSearchReplacement? = null,
  public val stableSegmentSearch: HciPartialSearchSegment? = null
)
