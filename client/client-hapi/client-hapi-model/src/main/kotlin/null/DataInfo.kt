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
  "DataInfo",
  "http://hacon.de/hafas/proxy/hafas-proxy",
  ""
)
public open class DataInfo : CommonResponse {
  @XmlSerialName(
    "Operator",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val `operator`: List<Operator>

  @XmlSerialName(
    "Product",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val product: List<Product>

  @XmlSerialName(
    "ProductCategory",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val productCategory: List<ProductCategory>

  @XmlSerialName(
    "Region",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val region: List<Region>

  @XmlSerialName(
    "MapInfo",
    "http://hacon.de/hafas/proxy/hafas-proxy",
    "hafas-proxy"
  )
  @XmlElement(true)
  public final val mapInfo: List<MapInfo>

  public constructor(
    technicalMessages: TechnicalMessages? = null,
    `operator`: List<Operator> = emptyList(),
    product: List<Product> = emptyList(),
    productCategory: List<ProductCategory> = emptyList(),
    region: List<Region> = emptyList(),
    mapInfo: List<MapInfo> = emptyList()
  ) : super(technicalMessages) {
    this.`operator` = `operator`
    this.product = product
    this.productCategory = productCategory
    this.region = region
    this.mapInfo = mapInfo
  }
}
