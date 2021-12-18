@file:UseSerializers(
    HciLocalDateSerializer::class,
    HciLocalTimeSerializer::class
)

package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalDateSerializer
import de.jlnstrk.transit.client.hci.serializer.time.HciLocalTimeSerializer
import de.jlnstrk.transit.util.LocalDate
import de.jlnstrk.transit.util.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@HciModel("1.39")
@Serializable
public data class HciUser(
    public val uId: String,
    public val dLocIdx: Int?,
    public val aLocIdx: Int?,
    public val mDate: LocalDate?,
    public val mTime: LocalTime?,
    public val uAppId: String?,
    public val uMail: String?,
    public val uName: String?,
    public val uPhotoUrl: String?,
    public val uRole: Role?,
    public val uVisible: Boolean?,
) {

    @Serializable
    public enum class Role {
        // TODO: Meaning?
        DR,

        // TODO: Meaning?
        SE,

        // TODO: Meaning?
        ST,

        // TODO: Meaning?
        TR,

        // TODO: Meaning?
        U
    }
}