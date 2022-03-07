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
import java.time.LocalDateTime
import kotlin.Int
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "JourneyDetail",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class JourneyDetail : CommonResponse {
  @XmlSerialName(
    "Stops",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val stops: Stops

  @XmlSerialName(
    "Names",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val names: Names?

  @XmlSerialName(
    "Product",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val product: List<Product>

  @XmlSerialName(
    "Directions",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val directions: Directions?

  @XmlSerialName(
    "Notes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val notes: Notes?

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
    "ServiceDays",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val serviceDays: List<ServiceDays>

  @XmlSerialName(
    "referencedJourney",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val referencedJourney: List<ReferencedJourney>

  @XmlSerialName(
    "lastPos",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val lastPos: Coordinate?

  @XmlSerialName(
    "lastPosReported",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val lastPosReported: LocalDateTime?

  @XmlSerialName(
    "lastPassRouteIdx",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val lastPassRouteIdx: Int?

  @XmlSerialName(
    "lastPassStopRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val lastPassStopRef: Int?

  @XmlSerialName(
    "rtLastPassRouteIdx",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val rtLastPassRouteIdx: Int?

  @XmlSerialName(
    "rtLastPassStopRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val rtLastPassStopRef: Int?

  @XmlSerialName(
    "ParallelJourneyRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val parallelJourneyRef: List<ParallelJourneyRef>

  public constructor(
    technicalMessages: TechnicalMessages? = null,
    stops: Stops,
    names: Names? = null,
    product: List<Product> = emptyList(),
    directions: Directions? = null,
    notes: Notes? = null,
    messages: Messages? = null,
    journeyStatus: JourneyStatus? = null,
    polyline: Polyline? = null,
    polylineGroup: PolylineBase? = null,
    serviceDays: List<ServiceDays> = emptyList(),
    referencedJourney: List<ReferencedJourney> = emptyList(),
    lastPos: Coordinate? = null,
    lastPosReported: LocalDateTime? = null,
    lastPassRouteIdx: Int? = null,
    lastPassStopRef: Int? = null,
    rtLastPassRouteIdx: Int? = null,
    rtLastPassStopRef: Int? = null,
    parallelJourneyRef: List<ParallelJourneyRef> = emptyList()
  ) : super(technicalMessages) {
    this.stops = stops
    this.names = names
    this.product = product
    this.directions = directions
    this.notes = notes
    this.messages = messages
    this.journeyStatus = journeyStatus
    this.polyline = polyline
    this.polylineGroup = polylineGroup
    this.serviceDays = serviceDays
    this.referencedJourney = referencedJourney
    this.lastPos = lastPos
    this.lastPosReported = lastPosReported
    this.lastPassRouteIdx = lastPassRouteIdx
    this.lastPassStopRef = lastPassStopRef
    this.rtLastPassRouteIdx = rtLastPassRouteIdx
    this.rtLastPassStopRef = rtLastPassStopRef
    this.parallelJourneyRef = parallelJourneyRef
  }
}
