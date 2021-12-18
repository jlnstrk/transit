package de.jlnstrk.transit.client.hci.model

import kotlinx.serialization.Serializable

@Serializable
public data class HciOperator(
    /** The name of this operator */
    public val name: String,

    /** The id of this operator */
    public val id: String?,

    /** The url associated with this operator */
    public val url: String?,

    public val town: String?,

    public val street: String?,

    public val phone: String?,

    public val fax: String?,

    public val email: String?,

    /** The index of the icon associated with this operator into [HciCommon.iconList] */
    public val icoX: Int?
)