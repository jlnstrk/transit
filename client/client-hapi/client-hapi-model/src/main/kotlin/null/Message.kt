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
  "Message",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Message {
  @XmlSerialName(
    "affectedProduct",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val affectedProduct: List<Product>

  @XmlSerialName(
    "affectedJourney",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val affectedJourney: List<Journey>

  @XmlSerialName(
    "edge",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val edge: List<MessageEdge>

  @XmlSerialName(
    "region",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val region: List<MessageRegion>

  @XmlSerialName(
    "event",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val event: List<MessageEvent>

  @XmlSerialName(
    "affectedStops",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val affectedStops: AffectedStop?

  @XmlSerialName(
    "validFromStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val validFromStop: Stop?

  @XmlSerialName(
    "validToStop",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val validToStop: Stop?

  @XmlSerialName(
    "tags",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val tags: Tags?

  @XmlSerialName(
    "channel",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val channel: List<MessageChannel>

  @XmlSerialName(
    "messageCategory",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messageCategory: List<MessageCategory>

  @XmlSerialName(
    "messageText",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val messageText: List<MessageText>

  @XmlSerialName(
    "validityDays",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val validityDays: ServiceDays?

  @XmlSerialName(
    "Note",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val note: List<Note>

  @XmlSerialName(
    "message",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val message: List<Message>

  public constructor(
    affectedProduct: List<Product> = emptyList(),
    affectedJourney: List<Journey> = emptyList(),
    edge: List<MessageEdge> = emptyList(),
    region: List<MessageRegion> = emptyList(),
    event: List<MessageEvent> = emptyList(),
    affectedStops: AffectedStop? = null,
    validFromStop: Stop? = null,
    validToStop: Stop? = null,
    tags: Tags? = null,
    channel: List<MessageChannel> = emptyList(),
    messageCategory: List<MessageCategory> = emptyList(),
    messageText: List<MessageText> = emptyList(),
    validityDays: ServiceDays? = null,
    note: List<Note> = emptyList(),
    message: List<Message> = emptyList()
  ) : super() {
    this.affectedProduct = affectedProduct
    this.affectedJourney = affectedJourney
    this.edge = edge
    this.region = region
    this.event = event
    this.affectedStops = affectedStops
    this.validFromStop = validFromStop
    this.validToStop = validToStop
    this.tags = tags
    this.channel = channel
    this.messageCategory = messageCategory
    this.messageText = messageText
    this.validityDays = validityDays
    this.note = note
    this.message = message
  }
}
