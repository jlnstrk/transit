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
  "GisRouteType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class GisRoute {
  @XmlSerialName(
    "seg",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val seg: List<GisRouteSegment>

  @XmlSerialName(
    "Notes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val notes: Notes?

  @XmlSerialName(
    "polyline",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polyline: Polyline?

  @XmlSerialName(
    "polylineGroup",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polylineGroup: PolylineBase?

  @XmlSerialName(
    "altPolyline",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val altPolyline: List<Polyline>

  @XmlSerialName(
    "altPolylineGroup",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val altPolylineGroup: List<PolylineBase>

  public constructor(
    seg: List<GisRouteSegment> = emptyList(),
    notes: Notes? = null,
    polyline: Polyline? = null,
    polylineGroup: PolylineBase? = null,
    altPolyline: List<Polyline> = emptyList(),
    altPolylineGroup: List<PolylineBase> = emptyList()
  ) : super() {
    this.seg = seg
    this.notes = notes
    this.polyline = polyline
    this.polylineGroup = polylineGroup
    this.altPolyline = altPolyline
    this.altPolylineGroup = altPolylineGroup
  }
}
