package de.jlnstrk.transit.api.hci.response

import de.jlnstrk.transit.api.hci.model.graph.HciGraph
import de.jlnstrk.transit.api.hci.model.HciView
import de.jlnstrk.transit.api.hci.serializer.HciResultFrameSerializer
import kotlinx.serialization.Serializable

@Serializable
public class HciResponse(
    public val ver: String,

    public val ext: String?,

    public val lang: String,

    public val id: String?,

    public val err: HciError?,

    public val graph: HciGraph?,

    public val subGraph: HciGraph?,

    public val view: HciView?,

    public val errTxt: String?,

    public val cInfo: Info?,

    public val svcResL: List<@Serializable(with = HciResultFrameSerializer::class) HciServiceResultFrame> = emptyList()
) {

    @Serializable
    public data class Info(
        public val code: HciError,
        public val url: String,
        public val message: String?
    )

}