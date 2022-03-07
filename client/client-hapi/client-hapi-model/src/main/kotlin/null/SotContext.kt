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
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName(
  "SotContextType",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class SotContext {
  @XmlSerialName(
    "calcDate",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val calcDate: String?

  @XmlSerialName(
    "calcTime",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val calcTime: String?

  @XmlSerialName(
    "journeyId",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val journeyId: String?

  @XmlSerialName(
    "trainName",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val trainName: String?

  @XmlSerialName(
    "legIdx",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val legIdx: Int?

  @XmlSerialName(
    "legIdxFootPathConnection",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val legIdxFootPathConnection: Int?

  @XmlSerialName(
    "prevLocRouteIdx",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val prevLocRouteIdx: Int?

  @XmlSerialName(
    "curLocRouteIdx",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val curLocRouteIdx: Int?

  @XmlSerialName(
    "locRouteIdxFootPathConnection",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val locRouteIdxFootPathConnection: Int?

  @XmlSerialName(
    "locMode",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val locMode: SotContextLocMode

  public constructor(
    calcDate: String? = null,
    calcTime: String? = null,
    journeyId: String? = null,
    trainName: String? = null,
    legIdx: Int? = null,
    legIdxFootPathConnection: Int? = null,
    prevLocRouteIdx: Int? = null,
    curLocRouteIdx: Int? = null,
    locRouteIdxFootPathConnection: Int? = null,
    locMode: SotContextLocMode
  ) : super() {
    this.calcDate = calcDate
    this.calcTime = calcTime
    this.journeyId = journeyId
    this.trainName = trainName
    this.legIdx = legIdx
    this.legIdxFootPathConnection = legIdxFootPathConnection
    this.prevLocRouteIdx = prevLocRouteIdx
    this.curLocRouteIdx = curLocRouteIdx
    this.locRouteIdxFootPathConnection = locRouteIdxFootPathConnection
    this.locMode = locMode
  }
}
