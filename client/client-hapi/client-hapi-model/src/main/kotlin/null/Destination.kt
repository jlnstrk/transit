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
  "Destination",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class Destination {
  @XmlSerialName(
    "Notes",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val notes: Notes?

  @XmlSerialName(
    "mcpData",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val mcpData: List<KV>

  @XmlSerialName(
    "Message",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val message: List<Message>

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
    "Occupancy",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val occupancy: List<Occupancy>

  public constructor(
    notes: Notes? = null,
    mcpData: List<KV> = emptyList(),
    message: List<Message> = emptyList(),
    altId: List<String> = emptyList(),
    mainMastAltId: List<String> = emptyList(),
    occupancy: List<Occupancy> = emptyList()
  ) : super() {
    this.notes = notes
    this.mcpData = mcpData
    this.message = message
    this.altId = altId
    this.mainMastAltId = mainMastAltId
    this.occupancy = occupancy
  }
}
