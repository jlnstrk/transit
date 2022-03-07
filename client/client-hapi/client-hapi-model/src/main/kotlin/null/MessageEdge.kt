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
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "MessageEdgeType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class MessageEdge {
  @XmlSerialName(
    "sStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val sStop: Stop?

  @XmlSerialName(
    "eStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val eStop: Stop?

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
    "messageRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messageRef: List<Int>

  public constructor(
    sStop: Stop? = null,
    eStop: Stop? = null,
    polyline: List<Polyline> = emptyList(),
    polylineGroup: PolylineBase? = null,
    iconCoordinate: Coordinate? = null,
    messageRef: List<Int> = emptyList()
  ) : super() {
    this.sStop = sStop
    this.eStop = eStop
    this.polyline = polyline
    this.polylineGroup = polylineGroup
    this.iconCoordinate = iconCoordinate
    this.messageRef = messageRef
  }
}
