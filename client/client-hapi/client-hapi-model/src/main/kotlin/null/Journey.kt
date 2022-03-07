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
  "JourneyType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Journey {
  @XmlSerialName(
    "Stops",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val stops: Stops?

  @XmlSerialName(
    "JourneyDetailRef",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyDetailRef: JourneyDetailRef?

  @XmlSerialName(
    "Product",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val product: Product?

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
    stops: Stops? = null,
    journeyDetailRef: JourneyDetailRef? = null,
    product: Product? = null,
    notes: Notes? = null,
    messages: Messages? = null,
    occupancy: List<Occupancy> = emptyList(),
    referencedJourney: List<ReferencedJourney> = emptyList()
  ) : super() {
    this.stops = stops
    this.journeyDetailRef = journeyDetailRef
    this.product = product
    this.notes = notes
    this.messages = messages
    this.occupancy = occupancy
    this.referencedJourney = referencedJourney
  }
}
