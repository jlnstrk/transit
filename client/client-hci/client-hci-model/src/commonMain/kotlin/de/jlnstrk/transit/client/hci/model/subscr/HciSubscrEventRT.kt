package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciNamedValue
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciSubscrEventRT(
  public val affectedIndex: Int? = null,
  public val changeId: String,
  public val changeSubType: String? = null,
  public val changeType: HciSubscrChangeType,
  public val channelId: String,
  public val channelType: HciSubscrChannelType,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val msg: String? = null,
  public val msgFormatted: String? = null,
  public val planrtTS: String? = null,
  public val received: String,
  public val statInfo: HciSubscrRTStatisticsInfo? = null,
  public val title: String? = null,
  public val trainInfo: HciSubscrRTTrainInfo? = null,
  public val rtConSecInfos: List<HciSubscrRTInfo> = emptyList(),
  public val templateVariables: List<HciNamedValue> = emptyList(),
)
