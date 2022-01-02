package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrResultStatus(
  public val externalError: HciSubscrError = HciSubscrError.UNDEF,
  public val internalError: String? = null,
  public val resultCode: HciSubscrResultCode
)
