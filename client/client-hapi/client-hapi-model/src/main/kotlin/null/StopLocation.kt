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
  "StopLocation",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class StopLocation {
  @XmlSerialName(
    "LocationNotes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val locationNotes: LocationNotes?

  @XmlSerialName(
    "Message",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val message: List<Message>

  @XmlSerialName(
    "productAtStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val productAtStop: List<Product>

  @XmlSerialName(
    "TariffResult",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val tariffResult: TariffResult?

  @XmlSerialName(
    "links",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val links: List<ResourceLinks>

  @XmlSerialName(
    "altId",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val altId: List<String>

  @XmlSerialName(
    "mainMastAltId",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val mainMastAltId: List<String>

  @XmlSerialName(
    "timezoneOffset",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val timezoneOffset: Int?

  public constructor(
    locationNotes: LocationNotes? = null,
    message: List<Message> = emptyList(),
    productAtStop: List<Product> = emptyList(),
    tariffResult: TariffResult? = null,
    links: List<ResourceLinks> = emptyList(),
    altId: List<String> = emptyList(),
    mainMastAltId: List<String> = emptyList(),
    timezoneOffset: Int? = null
  ) : super() {
    this.locationNotes = locationNotes
    this.message = message
    this.productAtStop = productAtStop
    this.tariffResult = tariffResult
    this.links = links
    this.altId = altId
    this.mainMastAltId = mainMastAltId
    this.timezoneOffset = timezoneOffset
  }
}
