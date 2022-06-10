package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciExternalContent
import de.jlnstrk.transit.client.hci.model.booking.HciBookingResult
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffResult(
  public val addData: String? = null,
  public val bkgData: HciBookingResult? = null,
  public val clickout: String? = null,
  public val extCont: HciExternalContent? = null,
  public val extContActionBar: HciExternalContent? = null,
  public val extContConSum: HciExternalContent? = null,
  public val extContOverview: HciExternalContent? = null,
  public val extContSticky: HciExternalContent? = null,
  public val reloadProfile: String? = null,
  public val statusCode: HciTariffStatusCode? = null,
  public val statusText: String? = null,
  public val totalPrice: HciTariffPrice? = null,
  public val trfCtxRecon: String? = null,
  public val fareSetL: List<HciTariffFareSet> = emptyList(),
  public val msgL: List<HciMessage> = emptyList(),
  public val tariffInfoBoxGroupL: List<HciTariffInfoBoxGroup> = emptyList(),
  public val variantL: List<HciTariffVariant> = emptyList(),
)
