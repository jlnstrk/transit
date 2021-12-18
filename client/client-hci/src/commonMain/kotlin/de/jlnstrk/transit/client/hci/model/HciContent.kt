package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciContent(
    public val content: String,
    public val type: Type,
) {

    @HciModel("1.39")
    @Serializable
    public enum class Type {
        APP_CTX,
        HTML,
        LIB_TARIFF,
        TKTLIB_EOS_PRODDATA,
        TKTLIB_EOS_RELDATA,
        TKTLIB_EOS_SERIALDATA,
        UNDEF,
        URL_APP,
        URL_EXT,
        URL_INT,
        URL_UNIVERSAL,
        WEBVIEW_TARIFF,
        XBOOK_CTX,
    }
}