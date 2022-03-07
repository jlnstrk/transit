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
  "ReferencedJourneyTypeType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class ReferencedJourneyType {
  @SerialName("UNDEF")
  UNDEF,
  @SerialName("DEFAULT")
  DEFAULT,
  @SerialName("IST_ERSATZFAHRT")
  IST_ERSATZFAHRT,
  @SerialName("IST_VERSTAERKERFAHRT")
  IST_VERSTAERKERFAHRT,
  @SerialName("IST_FORTFUEHRUNG")
  IST_FORTFUEHRUNG,
  @SerialName("IST_TRENNUNG")
  IST_TRENNUNG,
  @SerialName("IST_FORTFUEHRUNG_VON_TRENNUNG")
  IST_FORTFUEHRUNG_VON_TRENNUNG,
  @SerialName("IST_ZUSAMMENFUEHRUNG")
  IST_ZUSAMMENFUEHRUNG,
  @SerialName("IST_FORTFUEHRUNG_DURCH_ZUSAMMENFUEHRUNG")
  IST_FORTFUEHRUNG_DURCH_ZUSAMMENFUEHRUNG,
  @SerialName("IST_ENTLASTUNG")
  IST_ENTLASTUNG,
  @SerialName("DEFAULT_R")
  DEFAULT_R,
  @SerialName("HAT_ERSATZFAHRT")
  HAT_ERSATZFAHRT,
  @SerialName("HAT_VERSTAERKERFAHRT")
  HAT_VERSTAERKERFAHRT,
  @SerialName("HAT_FORTFUEHRUNG")
  HAT_FORTFUEHRUNG,
  @SerialName("HAT_TRENNUNG")
  HAT_TRENNUNG,
  @SerialName("HAT_FORTFUEHRUNG_VON_TRENNUNG")
  HAT_FORTFUEHRUNG_VON_TRENNUNG,
  @SerialName("HAT_ZUSAMMENFUEHRUNG")
  HAT_ZUSAMMENFUEHRUNG,
  @SerialName("HAT_FORTFUEHRUNG_DURCH_ZUSAMMENFUEHRUNG")
  HAT_FORTFUEHRUNG_DURCH_ZUSAMMENFUEHRUNG,
  @SerialName("HAT_ENTLASTUNG")
  HAT_ENTLASTUNG,
}
