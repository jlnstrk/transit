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
  "GeoFeatureType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class GeoFeature {
  @XmlSerialName(
    "provider",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val provider: Provider?

  @XmlSerialName(
    "icon",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val icon: Icon?

  @XmlSerialName(
    "coordinate",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val coordinate: List<Coordinate>

  @XmlSerialName(
    "lines",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val lines: List<Polyline>

  @XmlSerialName(
    "geoData",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val geoData: List<GeoData>

  @XmlSerialName(
    "validity",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val validity: List<DateTimeInterval>

  @XmlSerialName(
    "Note",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val note: List<Note>

  public constructor(
    provider: Provider? = null,
    icon: Icon? = null,
    coordinate: List<Coordinate> = emptyList(),
    lines: List<Polyline> = emptyList(),
    geoData: List<GeoData> = emptyList(),
    validity: List<DateTimeInterval> = emptyList(),
    note: List<Note> = emptyList()
  ) : super() {
    this.provider = provider
    this.icon = icon
    this.coordinate = coordinate
    this.lines = lines
    this.geoData = geoData
    this.validity = validity
    this.note = note
  }
}
