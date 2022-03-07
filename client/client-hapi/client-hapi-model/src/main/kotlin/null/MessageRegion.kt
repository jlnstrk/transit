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
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "MessageRegionType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class MessageRegion {
  @XmlSerialName(
    "name",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val name: String?

  @XmlSerialName(
    "id",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val id: String?

  @XmlSerialName(
    "polyline",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polyline: List<Polyline>

  @XmlSerialName(
    "polylineGroup",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polylineGroup: PolylineBase?

  @XmlSerialName(
    "iconCoordinate",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val iconCoordinate: Coordinate?

  @XmlSerialName(
    "ring",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val ring: Ring?

  @XmlSerialName(
    "messageRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messageRef: List<Int>

  public constructor(
    name: String? = null,
    id: String? = null,
    polyline: List<Polyline> = emptyList(),
    polylineGroup: PolylineBase? = null,
    iconCoordinate: Coordinate? = null,
    ring: Ring? = null,
    messageRef: List<Int> = emptyList()
  ) : super() {
    this.name = name
    this.id = id
    this.polyline = polyline
    this.polylineGroup = polylineGroup
    this.iconCoordinate = iconCoordinate
    this.ring = ring
    this.messageRef = messageRef
  }
}
