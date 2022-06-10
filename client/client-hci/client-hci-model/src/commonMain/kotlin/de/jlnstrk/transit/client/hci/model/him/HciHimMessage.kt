package de.jlnstrk.transit.client.hci.model.him

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciPolylineGroup
import de.jlnstrk.transit.client.hci.model.HciServiceDays
import de.jlnstrk.transit.client.hci.model.journey.HciJourney
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciHimMessage(
  public val altEnd: String? = null,
  public val altSection: String? = null,
  public val altStart: String? = null,
  public val baseType: HciHimMessageBaseType? = null,
  public val cDays: HciServiceDays? = null,
  public val comp: String? = null,
  public val cstm: String? = null,
  public val eDaily: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val eDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val eTime: HciLocalTime? = null,
  public val fIdx: Int? = null,
  public val fLocX: Int? = null,
  public val head: String? = null,
  public val hid: String? = null,
  public val icoX: Int? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val lModDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val lModTime: HciLocalTime? = null,
  public val lead: String? = null,
  public val output: String? = null,
  public val parMsgRefX: Int? = null,
  public val polyG: HciPolylineGroup? = null,
  public val sDaily: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val sDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val sTime: HciLocalTime? = null,
  public val src: Int? = null,
  public val tIdx: Int? = null,
  public val tLocX: Int? = null,
  public val tckr: String? = null,
  public val text: String? = null,
  public val textInternal: String? = null,
  public val uic: Int? = null,
  public val vDays: HciServiceDays? = null,
  public val affJnyL: List<HciJourney> = emptyList(),
  public val affProdRefL: List<Int> = emptyList(),
  public val catRefL: List<Int> = emptyList(),
  public val childMsgRefL: List<Int> = emptyList(),
  public val edgeRefL: List<Int> = emptyList(),
  public val eventRefL: List<Int> = emptyList(),
  public val gTagXL: List<Int> = emptyList(),
  public val impactL: List<HciHimImpact> = emptyList(),
  public val pubChL: List<HciHimMessageChannel> = emptyList(),
  public val rRefL: List<Int> = emptyList(),
  public val regionRefL: List<Int> = emptyList(),
  public val texts: List<HciHimMessageText> = emptyList(),
  public val uicL: List<Int> = emptyList(),
  public val act: Boolean = true,
  public val displayHead: Boolean = false,
  public val prio: Int = 100,
  public val prod: Int = 0,
)
