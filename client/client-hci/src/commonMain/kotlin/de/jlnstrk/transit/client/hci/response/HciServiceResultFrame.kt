package de.jlnstrk.transit.client.hci.response

import de.jlnstrk.transit.client.hci.method.HciServiceMethod
import kotlinx.serialization.Serializable

@Serializable
public class HciServiceResultFrame(
    /** The service method associated with the result */
    public val meth: HciServiceMethod,

    /** The status of the service result */
    public val err: HciServiceError,

    /** The description of the service error */
    public val errTxt: String?,

    /** The display description of the service error */
    public val errTxtOut: String?,

    /** The id of this result frame */
    public val id: String?,

    /** The context of this result frame */
    public val ctx: String?,

    // TODO: Meaning?
    public val statist: String?,

    /** The actual service result */
    public val res: HciServiceResult?
)