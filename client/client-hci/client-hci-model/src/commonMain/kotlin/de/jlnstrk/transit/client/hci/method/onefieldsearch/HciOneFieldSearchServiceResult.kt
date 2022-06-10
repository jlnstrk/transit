package de.jlnstrk.transit.client.hci.method.onefieldsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciOneFieldSearchFilters
import de.jlnstrk.transit.client.hci.model.HciOneFieldSearchRequest
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.location.HciLocationDataType
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciOneFieldSearchServiceResult(
  public val common: HciCommon? = null,
  public val filters: HciOneFieldSearchFilters? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val outDate: LocalDate? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val outTime: HciLocalTime? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val retDate: LocalDate? = null,
  public val retMode: HciLocationDataType? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val retTime: HciLocalTime? = null,
  public val reqL: List<HciOneFieldSearchRequest> = emptyList(),
  public val outMode: HciLocationDataType = HciLocationDataType.DEP,
  public val posReq: Boolean = false,
) : HciServiceResult()
