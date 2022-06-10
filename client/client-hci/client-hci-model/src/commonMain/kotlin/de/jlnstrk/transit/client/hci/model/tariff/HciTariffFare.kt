package de.jlnstrk.transit.client.hci.model.tariff

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciExternalContent
import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciTariffFare(
  public val addData: String? = null,
  public val addHint: String? = null,
  public val bookStatus: String? = null,
  public val buttonText: String? = null,
  public val circa: Boolean = false,
  public val desc: String? = null,
  public val descOverv: String? = null,
  public val dtl: String? = null,
  public val extCont: HciExternalContent? = null,
  public val fSecRefX: Int? = null,
  public val fStopRefX: Int? = null,
  public val filterProps: HciTariffFilterProps? = null,
  public val hasCity: Boolean = false,
  public val icoX: Int? = null,
  public val infoExt: HciExternalContent? = null,
  public val isBookable: Boolean = false,
  public val isFromPrice: Boolean = false,
  public val isPartPrice: Boolean = false,
  public val isUpsell: Boolean = false,
  public val name: String? = null,
  public val price: HciTariffPrice? = null,
  public val tSecRefX: Int? = null,
  public val tStopRefX: Int? = null,
  public val targetCtx: String? = null,
  public val verbundName: String? = null,
  public val msgL: List<HciMessage> = emptyList(),
  public val ticketL: List<HciTariffTicket> = emptyList(),
)
