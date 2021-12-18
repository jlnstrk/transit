package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@Serializable
public data class HciEvent(
    public val catOut: String,
    public val desc: String?,
    public val descAdd: String?,
    public val extEvtId: String,
    public val free: Boolean?,
    public val groupid: String?,
    public val icoX: Int?,
    public val msgL: List<HciMessage> = emptyList(),
    public val name: String,
    public val urlX: Int?,
    public val webview: String?,
)