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
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "Location",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Location {
  @XmlSerialName(
    "Note",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val note: List<LocationNote>

  public constructor(note: List<LocationNote> = emptyList()) : super() {
    this.note = note
  }
}
