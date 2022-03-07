@file:Suppress(
  "RedundantVisibilityModifier",
  "JoinDeclarationAndAssignment",
  "ConvertSecondaryConstructorToPrimary"
)
@file:UseSerializers(
  DateTimeSerializer::class,
  TimeSerializer::class,
  LocaleSerializer::class,
  DurationSerializer::class,
  AnySerializer::class,
  DateSerializer::class,
  FileSerializer::class
)

package `null`

import de.jlnstrk.transit.api.trias.serializer.AnySerializer
import de.jlnstrk.transit.api.trias.serializer.DateSerializer
import de.jlnstrk.transit.api.trias.serializer.DateTimeSerializer
import de.jlnstrk.transit.api.trias.serializer.DurationSerializer
import de.jlnstrk.transit.api.trias.serializer.FileSerializer
import de.jlnstrk.transit.api.trias.serializer.LocaleSerializer
import de.jlnstrk.transit.api.trias.serializer.TimeSerializer
import kotlin.Suppress
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "GisRouteManoeuvre",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class GisRouteManoeuvre {
  @SerialName("NO")
  NO,
  @SerialName("FR")
  FR,
  @SerialName("TO")
  TO,
  @SerialName("ON")
  ON,
  @SerialName("LE")
  LE,
  @SerialName("RI")
  RI,
  @SerialName("KL")
  KL,
  @SerialName("KR")
  KR,
  @SerialName("HL")
  HL,
  @SerialName("HR")
  HR,
  @SerialName("KHL")
  KHL,
  @SerialName("KHR")
  KHR,
  @SerialName("SL")
  SL,
  @SerialName("SR")
  SR,
  @SerialName("KSL")
  KSL,
  @SerialName("KSR")
  KSR,
  @SerialName("ST")
  ST,
  @SerialName("UT")
  UT,
  @SerialName("EN")
  EN,
  @SerialName("LV")
  LV,
  @SerialName("ER")
  ER,
  @SerialName("SIR")
  SIR,
  @SerialName("LR")
  LR,
  @SerialName("EF")
  EF,
  @SerialName("LF")
  LF,
  @SerialName("CH")
  CH,
  @SerialName("CIF")
  CIF,
  @SerialName("COF")
  COF,
  @SerialName("EL")
  EL,
  @SerialName("ELD")
  ELD,
  @SerialName("ELU")
  ELU,
  @SerialName("ES")
  ES,
  @SerialName("ESD")
  ESD,
  @SerialName("ESU")
  ESU,
  @SerialName("STA")
  STA,
  @SerialName("STD")
  STD,
  @SerialName("STU")
  STU,
}
