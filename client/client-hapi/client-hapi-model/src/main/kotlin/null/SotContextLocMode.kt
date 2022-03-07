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
  "SotContextLocModeType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class SotContextLocMode {
  @SerialName("UNKNOWN")
  UNKNOWN,
  @SerialName("FROM_START")
  FROM_START,
  @SerialName("IN_TRAIN")
  IN_TRAIN,
  @SerialName("AT_PASSED_STOP")
  AT_PASSED_STOP,
  @SerialName("AT_CHANGE_STOP")
  AT_CHANGE_STOP,
  @SerialName("BEFORE_TRAVEL")
  BEFORE_TRAVEL,
  @SerialName("AT_DESTINATION")
  AT_DESTINATION,
  @SerialName("ERROR")
  ERROR,
  @SerialName("ERROR_SEARCH_FROM_TRAIN_BEFORE_START")
  ERROR_SEARCH_FROM_TRAIN_BEFORE_START,
  @SerialName("ERROR_IN_RECONSTRUCTION")
  ERROR_IN_RECONSTRUCTION,
  @SerialName("TO_BE_DEFINED_IN_SERVER")
  TO_BE_DEFINED_IN_SERVER,
  @SerialName("ERROR_TRAIN_CANCELLED")
  ERROR_TRAIN_CANCELLED,
  @SerialName("CHECK_COMPLETE_TRAIN")
  CHECK_COMPLETE_TRAIN,
  @SerialName("AT_LAST_USABLE_STOP")
  AT_LAST_USABLE_STOP,
  @SerialName("ERROR_ALL_TRAINS_FILTERED")
  ERROR_ALL_TRAINS_FILTERED,
  @SerialName("ERROR_STAY_IN_CURRENT_CONNECTION")
  ERROR_STAY_IN_CURRENT_CONNECTION,
}
