@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.api.hci.method.himdetails

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hci.request.HciServiceRequest
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public class HciHimDetailsRequest(
    public var date: LocalDate? = null,
    public var endDate: LocalDate? = null,
    public var endTime: LocalTime? = null,
    public var getPolyLine: Boolean? = null,
    public var getTrains: Boolean? = null,
    public var input: String? = null,
    public var polyLineRes: Int? = null,
    public var time: LocalTime? = null
) : HciServiceRequest<HciHimDetailsResult>() {
    override val method: HciServiceMethod get() = HciServiceMethod.HIM_DETAILS

    public companion object {
        public inline operator fun invoke(init: HciHimDetailsRequest.() -> Unit): HciHimDetailsRequest =
            HciHimDetailsRequest().apply(init)
    }
}