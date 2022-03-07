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
  "Leg",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Leg {
  @XmlSerialName(
    "Origin",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val origin: OriginDest

  @XmlSerialName(
    "Destination",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val destination: OriginDest

  @XmlSerialName(
    "Notes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val notes: Notes?

  @XmlSerialName(
    "JourneyDetailRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyDetailRef: JourneyDetailRef?

  @XmlSerialName(
    "Freq",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val freq: Freq?

  @XmlSerialName(
    "GisRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val gisRef: GisRef?

  @XmlSerialName(
    "GisRoute",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val gisRoute: GisRoute?

  @XmlSerialName(
    "Messages",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messages: Messages?

  @XmlSerialName(
    "JourneyStatus",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyStatus: JourneyStatus?

  @XmlSerialName(
    "Product",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val product: List<Product>

  @XmlSerialName(
    "Polyline",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polyline: Polyline?

  @XmlSerialName(
    "PolylineGroup",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val polylineGroup: PolylineBase?

  @XmlSerialName(
    "Stops",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val stops: Stops?

  @XmlSerialName(
    "ServiceDays",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val serviceDays: List<ServiceDays>

  @XmlSerialName(
    "JourneyDetail",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyDetail: JourneyDetail?

  @XmlSerialName(
    "ParallelJourney",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val parallelJourney: List<Journey>

  @XmlSerialName(
    "Occupancy",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val occupancy: List<Occupancy>

  @XmlSerialName(
    "referencedJourney",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val referencedJourney: List<ReferencedJourney>

  public constructor(
    origin: OriginDest,
    destination: OriginDest,
    notes: Notes? = null,
    journeyDetailRef: JourneyDetailRef? = null,
    freq: Freq? = null,
    gisRef: GisRef? = null,
    gisRoute: GisRoute? = null,
    messages: Messages? = null,
    journeyStatus: JourneyStatus? = null,
    product: List<Product> = emptyList(),
    polyline: Polyline? = null,
    polylineGroup: PolylineBase? = null,
    stops: Stops? = null,
    serviceDays: List<ServiceDays> = emptyList(),
    journeyDetail: JourneyDetail? = null,
    parallelJourney: List<Journey> = emptyList(),
    occupancy: List<Occupancy> = emptyList(),
    referencedJourney: List<ReferencedJourney> = emptyList()
  ) : super() {
    this.origin = origin
    this.destination = destination
    this.notes = notes
    this.journeyDetailRef = journeyDetailRef
    this.freq = freq
    this.gisRef = gisRef
    this.gisRoute = gisRoute
    this.messages = messages
    this.journeyStatus = journeyStatus
    this.product = product
    this.polyline = polyline
    this.polylineGroup = polylineGroup
    this.stops = stops
    this.serviceDays = serviceDays
    this.journeyDetail = journeyDetail
    this.parallelJourney = parallelJourney
    this.occupancy = occupancy
    this.referencedJourney = referencedJourney
  }
}
