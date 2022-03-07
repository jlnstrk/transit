package de.jlnstrk.transit.client.hci.model.connection

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciConnectionStatus(
  public val convenient: Boolean = false,
  public val daily: Boolean = false,
  public val detour: Boolean = false,
  public val direct: Boolean = false,
  public val economic: Boolean = false,
  public val hint: String? = null,
  public val hintCode: Int? = null,
  public val slowDirect: Boolean = false,
  public val specialtrain: Boolean = false,
  public val subOptimalDirect: Boolean = false,
  public val timeDiffCritical: Boolean = false,
  public val ukNationalRouteingGuideFailure: Boolean = false,
  public val unsharp: Boolean = false
)
