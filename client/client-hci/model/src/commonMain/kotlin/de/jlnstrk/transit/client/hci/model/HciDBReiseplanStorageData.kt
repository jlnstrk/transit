package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciDBReiseplanStorageData(
  public val channel: String? = null,
  public val reservation: String? = null,
  public val shortId: String? = null,
  public val type: String? = null,
  public val vh_amount_travellers: Int = -1,
  public val vr_amount_travellers: Int = -1
)
