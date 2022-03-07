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
  "TripList",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class TripList : CommonResponse {
  @XmlSerialName(
    "Trip",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val trip: List<Trip>

  @XmlSerialName(
    "Pricing",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val pricing: List<Pricing>

  @XmlSerialName(
    "SotContext",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val sotContext: SotContext?

  @XmlSerialName(
    "ResultStatus",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val resultStatus: ResultStatus?

  public constructor(
    technicalMessages: TechnicalMessages? = null,
    trip: List<Trip> = emptyList(),
    pricing: List<Pricing> = emptyList(),
    sotContext: SotContext? = null,
    resultStatus: ResultStatus? = null
  ) : super(technicalMessages) {
    this.trip = trip
    this.pricing = pricing
    this.sotContext = sotContext
    this.resultStatus = resultStatus
  }
}