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
  "ManyToManyConnectionRequest",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class ManyToManyConnectionRequest {
  @XmlSerialName(
    "origin",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val origin: Location

  @XmlSerialName(
    "destination",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val destination: Location

  @XmlSerialName(
    "via",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val via: List<Via>

  @XmlSerialName(
    "avoid",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val avoid: List<Avoid>

  @XmlSerialName(
    "frontPreselection",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val frontPreselection: List<RoutingPreselection>

  @XmlSerialName(
    "backPreselection",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val backPreselection: List<RoutingPreselection>

  @XmlSerialName(
    "gisProfile",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val gisProfile: List<GisProfile>

  @XmlSerialName(
    "filters",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val filters: TripSearchFilter

  @XmlSerialName(
    "searchOptions",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val searchOptions: SearchOptions

  @XmlSerialName(
    "outputControl",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val outputControl: OutputControl

  public constructor(
    origin: Location,
    destination: Location,
    via: List<Via> = emptyList(),
    avoid: List<Avoid> = emptyList(),
    frontPreselection: List<RoutingPreselection> = emptyList(),
    backPreselection: List<RoutingPreselection> = emptyList(),
    gisProfile: List<GisProfile> = emptyList(),
    filters: TripSearchFilter,
    searchOptions: SearchOptions,
    outputControl: OutputControl
  ) : super() {
    this.origin = origin
    this.destination = destination
    this.via = via
    this.avoid = avoid
    this.frontPreselection = frontPreselection
    this.backPreselection = backPreselection
    this.gisProfile = gisProfile
    this.filters = filters
    this.searchOptions = searchOptions
    this.outputControl = outputControl
  }
}
