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
  "ReconstructionSectionType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class ReconstructionSection {
  @SerialName("JNY")
  JNY,
  @SerialName("WALK")
  WALK,
  @SerialName("TRSF")
  TRSF,
  @SerialName("DEVI")
  DEVI,
  @SerialName("GIS_FOOT")
  GIS_FOOT,
  @SerialName("GIS_BIKE")
  GIS_BIKE,
  @SerialName("GIS_PARK")
  GIS_PARK,
  @SerialName("GIS_KISS")
  GIS_KISS,
  @SerialName("GIS_TAXI")
  GIS_TAXI,
}
