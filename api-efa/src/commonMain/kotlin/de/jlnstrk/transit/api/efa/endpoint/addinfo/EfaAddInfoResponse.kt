@file:UseSerializers(
    EfaStringBooleanSerializer::class,
    EfaPrimitiveSerializer.ForString::class,
    EfaPrimitiveSerializer.ForFloat::class
)

package de.jlnstrk.transit.api.efa.endpoint.addinfo

import de.jlnstrk.transit.api.efa.model.EfaTravelInfo
import de.jlnstrk.transit.api.efa.response.EfaResponse
import de.jlnstrk.transit.api.efa.serializer.generic.EfaOptionalListSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.EfaStringBooleanSerializer
import de.jlnstrk.transit.api.efa.serializer.primitive.datetime.EfaStringDateTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public class EfaAddInfoResponse(
    public val additionalInformation: AdditionalInfo
) : EfaResponse() {

    @Serializable
    public data class AdditionalInfo(
        @Serializable(with = EfaStringDateTimeSerializer.Date::class)
        public val date: LocalDate,
        @Serializable(with = EfaStringDateTimeSerializer.Time::class)
        public val time: LocalTime,
        public val filterParams: Map<String, String>?,
        @Serializable(with = EfaOptionalListSerializer::class)
        public val travelInformations: List<TravelInformationGroup>
    ) {

        @Serializable
        public data class TravelInformationGroup(
            public val status: PublicationStatus,
            public val travelInformation: List<EfaTravelInfo>
        )

        @Serializable
        public enum class PublicationStatus {
            @SerialName("current")
            CURRENT,

            @SerialName("history")
            HISTORY,
        }
    }
}