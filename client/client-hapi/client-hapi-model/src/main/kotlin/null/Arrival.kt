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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "Arrival",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Arrival {
  @XmlSerialName(
    "JourneyDetailRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyDetailRef: JourneyDetailRef

  @XmlSerialName(
    "JourneyStatus",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyStatus: JourneyStatus?

  @XmlSerialName(
    "ProductAtStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val productAtStop: Product?

  @XmlSerialName(
    "Product",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val product: List<Product>

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
    "Directions",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val directions: Directions?

  @XmlSerialName(
    "altId",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val altId: List<String>

  @XmlSerialName(
    "Stops",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val stops: Stops?

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
    journeyDetailRef: JourneyDetailRef,
    journeyStatus: JourneyStatus? = null,
    productAtStop: Product? = null,
    product: List<Product> = emptyList(),
    notes: Notes? = null,
    messages: Messages? = null,
    directions: Directions? = null,
    altId: List<String> = emptyList(),
    stops: Stops? = null,
    occupancy: List<Occupancy> = emptyList(),
    referencedJourney: List<ReferencedJourney> = emptyList()
  ) : super() {
    this.journeyDetailRef = journeyDetailRef
    this.journeyStatus = journeyStatus
    this.productAtStop = productAtStop
    this.product = product
    this.notes = notes
    this.messages = messages
    this.directions = directions
    this.altId = altId
    this.stops = stops
    this.occupancy = occupancy
    this.referencedJourney = referencedJourney
  }
}
