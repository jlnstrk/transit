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
  "GisRouteRoadType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class GisRouteRoad {
  @SerialName("U")
  U,
  @SerialName("M")
  M,
  @SerialName("H")
  H,
  @SerialName("T")
  T,
  @SerialName("T4L")
  T4L,
  @SerialName("T2L")
  T2L,
  @SerialName("TR")
  TR,
  @SerialName("NT")
  NT,
  @SerialName("CT")
  CT,
  @SerialName("R")
  R,
  @SerialName("B")
  B,
  @SerialName("CW")
  CW,
  @SerialName("C")
  C,
  @SerialName("W")
  W,
  @SerialName("F")
  F,
}
