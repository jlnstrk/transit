@file:UseSerializers(
    EfaStringBooleanSerializer::class
)

package de.jlnstrk.transit.api.efa.endpoint.dm

import de.jlnstrk.transit.api.efa.model.EfaJourney
import de.jlnstrk.transit.api.efa.endpoint.trip.EfaTripRequest
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaTimetableResponse
import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

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
            public val changeSpeed: EfaTripRequest.ChangeSpeed?,
            public val lineRestriction: EfaTripRequest.PtOptions.LineRestriction,
            public val useProxFootSearch: Boolean,
            public val useProxFootSearchOrigin: Boolean,
            public val useProxFootSearchDestination: Boolean,
            public val bike: Boolean,
            public val plane: Boolean,
            public val noCrowded: Boolean,
            public val noSolidStairs: Boolean,
            public val noEscalators: Boolean,
            public val noElevators: Boolean,
            public val lowPlatformVhcl: Boolean,
            public val wheelchair: Boolean,
            public val needElevatedPlt: Boolean,
            public val assistance: Boolean,
            public val SOSAvail: Boolean,
            public val noLonelyTransfer: Boolean,
            public val illumTransfer: Boolean,
            public val overgroundTransfer: Boolean,
            public val noInsecurePlaces: Boolean,
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
                public val selected: Boolean
            )
        }
    }

    @Serializable
    public class ServingLines(
        public val trainInfo: TrainInfo?,
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