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
  "NoteType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public enum class Note {
  @SerialName("U")
  U,
  @SerialName("A")
  A,
  @SerialName("I")
  I,
  @SerialName("R")
  R,
  @SerialName("H")
  H,
  @SerialName("M")
  M,
  @SerialName("C")
  C,
  @SerialName("D")
  D,
  @SerialName("B")
  B,
  @SerialName("Q")
  Q,
  @SerialName("L")
  L,
  @SerialName("N")
  N,
  @SerialName("O")
  O,
  @SerialName("P")
  P,
  @SerialName("S")
  S,
  @SerialName("V")
  V,
  @SerialName("X")
  X,
  @SerialName("Z")
  Z,
  @SerialName("Y")
  Y,
  @SerialName("K")
  K,
  @SerialName("G")
  G,
  @SerialName("W")
  W,
  @SerialName("ED")
  ED,
  @SerialName("TAR")
  TAR,
  @SerialName("FN")
  FN,
  @SerialName("TLN")
  TLN,
}
