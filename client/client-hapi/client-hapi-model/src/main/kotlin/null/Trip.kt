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
  "TripType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Trip {
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
    "Messages",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messages: Messages?

  @XmlSerialName(
    "Notes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val notes: Notes?

  @XmlSerialName(
    "Eco",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val eco: Eco?

  @XmlSerialName(
    "EcoCmp",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val ecoCmp: List<Eco>

  @XmlSerialName(
    "ServiceDays",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val serviceDays: List<ServiceDays>

  @XmlSerialName(
    "Freq",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val freq: Freq?

  @XmlSerialName(
    "LegList",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val legList: LegList

  @XmlSerialName(
    "TariffResult",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val tariffResult: TariffResult?

  @XmlSerialName(
    "calculation",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val calculation: Calculation?

  @XmlSerialName(
    "Occupancy",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val occupancy: List<Occupancy>

  @XmlSerialName(
    "reliability",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val reliability: ConnectionReliability?

  @XmlSerialName(
    "TripStatus",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val tripStatus: TripStatus?

  @XmlSerialName(
    "via",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val via: List<Stop>

  public constructor(
    origin: OriginDest,
    destination: OriginDest,
    messages: Messages? = null,
    notes: Notes? = null,
    eco: Eco? = null,
    ecoCmp: List<Eco> = emptyList(),
    serviceDays: List<ServiceDays> = emptyList(),
    freq: Freq? = null,
    legList: LegList,
    tariffResult: TariffResult? = null,
    calculation: Calculation? = null,
    occupancy: List<Occupancy> = emptyList(),
    reliability: ConnectionReliability? = null,
    tripStatus: TripStatus? = null,
    via: List<Stop> = emptyList()
  ) : super() {
    this.origin = origin
    this.destination = destination
    this.messages = messages
    this.notes = notes
    this.eco = eco
    this.ecoCmp = ecoCmp
    this.serviceDays = serviceDays
    this.freq = freq
    this.legList = legList
    this.tariffResult = tariffResult
    this.calculation = calculation
    this.occupancy = occupancy
    this.reliability = reliability
    this.tripStatus = tripStatus
    this.via = via
  }
}
