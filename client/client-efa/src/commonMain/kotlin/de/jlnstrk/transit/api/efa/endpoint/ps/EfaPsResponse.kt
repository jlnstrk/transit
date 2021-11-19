package de.jlnstrk.transit.api.efa.endpoint.ps

import de.jlnstrk.transit.api.efa.model.EfaDownload
import de.jlnstrk.transit.api.efa.response.EfaPointVerification
import de.jlnstrk.transit.api.efa.response.EfaResponse
import kotlinx.serialization.Serializable

@Serializable
public class EfaPsResponse(
    public val origin: EfaPointVerification,
    public val destination: EfaPointVerification,
    public val via: EfaPointVerification?,
    public val printControl: PrintControl,
) : EfaResponse() {

    @Serializable
    public data class PrintControl(
        public val outputType: OutputType,
        public val psFileName: String?,
        public val itdDownload: EfaDownload?,
    ) {

        @Serializable
        public enum class OutputType {
            PDF,
        }
    }
}