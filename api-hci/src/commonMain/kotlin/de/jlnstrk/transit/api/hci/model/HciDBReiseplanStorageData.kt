package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciDBReiseplanStorageData(
    public val channel: String?,
    public val reservation: String?,
    public val shortId: String?,
    public val type: String?,
    public val vh_amount_travellers: Int?,
    public val vr_amount_travellers: Int?,
)