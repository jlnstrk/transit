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
  "CalculationType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class Calculation {
  @SerialName("INITIAL")
  INITIAL,
  @SerialName("RETRY_SHARP")
  RETRY_SHARP,
  @SerialName("RETRY_UNSHARP")
  RETRY_UNSHARP,
  @SerialName("RETRY_DOUBLE_RADIUS")
  RETRY_DOUBLE_RADIUS,
  @SerialName("RETRY_UNSHARP_NEW_RADIUS")
  RETRY_UNSHARP_NEW_RADIUS,
}
