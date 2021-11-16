package de.jlnstrk.transit.api.efa.endpoint.dm

import de.jlnstrk.transit.api.efa.model.EfaJourney
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaTimetableResponse
import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public class EfaDmResponse(
    public val dm: EfaPointVerification,
    public val arr: EfaPointVerification,
    public val servingLines: ServingLines,
    @Serializable(with = EfaOptionalListSerializer::class)
    public val arrivalList: List<EfaJourney> = emptyList(),
    @Serializable(with = EfaOptionalListSerializer::class)
    public val departureList: List<EfaJourney> = emptyList()
) : EfaTimetableResponse() {

    @Serializable
    public class Options(
        public val ptOption: PublicTransportOption
    ) {

        @Serializable
        public class PublicTransportOption(
            public val active: String,
            public val maxChanges: Int,
            public val maxTime: Int,
            public val maxWait: Int,
            public val routeType: EfaTripRequest.PtOptions.RouteType,
            public val changeSpeed: EfaTripRequest.ChangeSpeed,
            public val lineRestriction: EfaTripRequest.PtOptions.LineRestriction,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val useProxFootSearch: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val useProxFootSearchOrigin: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val useProxFootSearchDestination: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val bike: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val plane: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noCrowded: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noSolidStairs: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noEscalators: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noElevators: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val lowPlatformVhcl: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val wheelchair: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val needElevatedPlt: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val assistance: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val SOSAvail: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noLonelyTransfer: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val illumTransfer: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val overgroundTransfer: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val noInsecurePlaces: Boolean,

            @Serializable(with = EfaStringBooleanSerializer::class)
            public val privateTransport: Boolean,

            public val excludedMeans: List<Means>,

            public val activeImp: Int,
            public val activeCom: Int,
            public val activeSec: Int
        ) {

            @Serializable
            public class Means(
                public val means: String,
                public val value: Int,
                @Serializable(with = EfaStringBooleanSerializer::class)
                public val selected: Boolean
            )
        }
    }

    @Serializable
    public class ServingLines(
        public val trainInfo: TrainInfo?,
        @Serializable(with = EfaStringBooleanSerializer::class)
        public val selected: Boolean = false,
        public val lines: List<EfaLineEntry> = emptyList()
    ) {
        @Serializable
        public enum class TrainInfo {
            @SerialName("show")
            SHOW
        }
    }
}