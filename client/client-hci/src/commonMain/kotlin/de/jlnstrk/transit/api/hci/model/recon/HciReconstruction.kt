@file:UseSerializers(
    HciLocalDateSerializer::class
)

package de.jlnstrk.transit.api.hci.model.recon

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciReconstruction(
    public val conId: String? = null,
    public val ctx: String? = null,
    public val date: LocalDate? = null,
    public val rBhv: Behavior? = null,
    public val secDataL: List<HciReconstructionSectionData> = emptyList(),
) {

    @HciModel("1.39")
    @Serializable
    public enum class Behavior {
        // TODO: Meaning?
        AR,

        // TODO: Meaning?
        OC,

        // TODO: Meaning?
        U
    }

    @HciModel("1.39")
    @Serializable
    public enum class State {
        // TODO: Meaning?
        C,

        // TODO: Meaning?
        N,

        // TODO: Meaning?
        O,

        // TODO: Meaning?
        P,

        // TODO: Meaning?
        U
    }
}