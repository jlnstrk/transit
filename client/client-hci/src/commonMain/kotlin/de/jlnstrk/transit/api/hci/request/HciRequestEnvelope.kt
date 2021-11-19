package de.jlnstrk.transit.api.hci.request

import de.jlnstrk.transit.api.hci.method.HciServiceMethod
import de.jlnstrk.transit.api.hafas.HafasPolylineEncoding
import de.jlnstrk.transit.api.hafas.HafasRealtimeMode
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
public data class HciRequestEnvelope(
    public val req: HciServiceRequest<*>,

    @Required
    public val meth: HciServiceMethod = req.method,

    public val cfg: Configuration?,
) {

    @Serializable
    public class Configuration(
        public val cfgHash: String? = null,

        public val polyEnc: HafasPolylineEncoding? = null,

        public val rtMode: HafasRealtimeMode? = null,

        // TODO: cfgGroupL
    ) {

    }

}