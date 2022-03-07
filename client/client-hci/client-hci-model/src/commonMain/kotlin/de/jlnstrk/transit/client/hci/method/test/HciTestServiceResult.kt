package de.jlnstrk.transit.client.hci.method.test

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.HciLocalTimeSerializer
import de.jlnstrk.transit.client.hci.util.HciLocalTime
import de.jlnstrk.transit.util.LocalDate
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciTestServiceResult(
  public val outBool: Boolean = false,
  @Serializable(with = HciLocalDateSerializer::class)
  public val outDate: LocalDate? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val outDateTime: LocalDate? = null,
  public val outFloat: Double = 0.000000,
  public val outStr: String? = null,
  @Serializable(with = HciLocalTimeSerializer.WithDayOffset::class)
  public val outTime: HciLocalTime? = null,
  public val output: String? = null,
  public val outputBool: Boolean = false,
  public val outputFloat: Double = 0.000000,
  public val outInt: Int = 0,
  public val outLong: Int = 0,
  public val outputInt: Int = 0,
  public val outputLong: Int = 0
) : HciServiceResult()
