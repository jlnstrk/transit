@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.client.efa.model

import de.jlnstrk.transit.client.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.client.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers


@Serializable
public data class EfaPin(
    public val desc: String,

    public val addDesc: String?,

    public val type: Type,

    public val id: Long,

    public val omc: Long,

    public val placeID: Long,

    public val locality: String,

    public val layer: String,

    public val gisID: Long,

    public val distance: Int,

    public val stateless: Long,

    @Contextual
    public val coords: EfaCoordinates,

    public val attrs: List<Attribute>
) {

    public sealed interface Attribute {

        public data class StopGlobalId(
            public val globalId: String
        ) : Attribute

        public data class StopNameWithPlace(
            public val nameWithPlace: String
        ) : Attribute

        public data class StopMajorMeans(
            public val majorMeans: EfaMeansOfTransport
        ) : Attribute

        public data class StopMeansList(
            public val means: Set<EfaMeansOfTransport>
        ) : Attribute

        public data class StopTariffZones(
            public val network: String,
            public val tariffZones: IntArray
        ) : Attribute

        public data class StopSurroundingMap(
            public val relLink: String
        ) : Attribute

        @Serializable
        public data class Other(
            public val key: String,
            public val value: String
        ) : Attribute
    }

    public enum class Type {
        ANY,
        BUS_POINT,
        ENTRANCE,
        GIS_AREA,
        GIS_POINT,
        LINE,
        POI_AREA,
        POI_POINT,
        STOP,
        STREET
    }
}