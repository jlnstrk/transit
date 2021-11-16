@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.serializer.EfaMeansSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("anyType")
public sealed class EfaPoint(
    /** The name of this point */
    public val name: String,

    /** The point reference of this point */
    public val ref: EfaReference? = null,

    /** The stateless identifier of this point */
    public val stateless: String? = null,

    /** The sort index of this point */
    public val sort: Int? = null,

    /** The request match quality of this point */
    public val quality: Int? = null,

    // TODO: Type?
    /** The infos associated with this point */
    public val infos: String? = null,

    /** Whether the EFA server has static info on this point */
    public val hasStaticInfo: Boolean = false
) {
    /** The point verification usage of this point */
    public var usage: EfaPointVerification.Usage? = null
        private set

    /** The point verification type of this point */
    public var type: EfaPointVerification.Type? = null
        private set

    /** Utility constructor to create an untyped [EfaPoint] for requests */
    protected constructor(
        name: String,
        type: EfaPointVerification.Type
    ) : this(name) {
        this.type = type
    }

    @Serializable
    public class Any : EfaPoint {
        public constructor(
            name: String,
            type: EfaPointVerification.Type
        ) : super(name, type)

        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo)
    }

    @Serializable
    @SerialName("loc")
    public class Place : EfaPoint {
        /** Utility constructor to create a [Place] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo)
    }

    @Serializable
    @SerialName("street")
    public class Street : EfaPoint {
        /** The object title of this street */
        @SerialName("object")
        public var obj: String? = null
            private set

        /** The street name */
        public var street: String? = null
            private set

        /** Utility constructor to create a [Street] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
            obj: String? = null,
            street: String? = null,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo) {
            this.obj = obj
            this.street = street
        }
    }

    @Serializable
    @SerialName("singlehouse")
    public class SingleHouse : EfaPoint {
        /** The object title of this single house */
        @SerialName("object")
        public var obj: String? = null
            private set

        /** The street name of this single house */
        public var street: String? = null
            private set

        /** The building number of this single house */
        public var buildingNumber: String? = null
            private set

        /** Utility constructor to create a [SingleHouse] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
            obj: String? = null,
            street: String? = null,
            buildingNumber: String? = null,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo) {
            this.obj = obj
            this.street = street
            this.buildingNumber = buildingNumber
        }
    }

    @Serializable
    @SerialName("stop")
    public class Stop : EfaPoint {
        /** The object title of this stop */
        @SerialName("object")
        public var obj: String? = null
            private set

        /** The post town of this stop */
        public var posttown: String? = null
            private set

        /** The means of transport associated with this stop */
        @Serializable(with = EfaMeansSerializer.Set::class)
        public var modes: Set<EfaMeansOfTransport>? = null
            private set

        /** Utility constructor to create a [Stop] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
            obj: String? = null,
            postTown: String? = null,
            modes: Set<EfaMeansOfTransport>? = null
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo) {
            this.obj = obj
            this.posttown = postTown
            this.modes = modes
        }
    }

    @Serializable
    @SerialName("poi")
    public class Poi : EfaPoint {
        /** The object title of this POI */
        @SerialName("object")
        public var obj: String? = null
            private set

        /** Utility constructor to create a [Poi] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
            obj: String? = null
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo) {
            this.obj = obj
        }
    }

    @Serializable
    @SerialName("postcode")
    public class PostCode : EfaPoint {
        /** Utility constructor to create a [PostCode] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo)
    }

    @Serializable
    @SerialName("crossing")
    public class Crossing : EfaPoint {
        /** Utility constructor to create a [Crossing] for requests */
        public constructor(
            name: String,
            reference: EfaReference? = null,
            stateless: String? = null,
            sort: Int? = null,
            quality: Int? = null,
            infos: String? = null,
            hasStaticInfo: Boolean = false,
        ) : super(name, reference, stateless, sort, quality, infos, hasStaticInfo)
    }

    @Serializable
    public enum class ObjectType {
        @SerialName("loc")
        LOC,

        @SerialName("stop")
        STOP,

        @SerialName("street")
        STREET,

        @SerialName("singlehouse")
        SINGLE_HOUSE,

        @SerialName("crossing")
        CROSSING,

        @SerialName("poi")
        POI,

        @SerialName("postcode")
        POSTCODE
    }
}