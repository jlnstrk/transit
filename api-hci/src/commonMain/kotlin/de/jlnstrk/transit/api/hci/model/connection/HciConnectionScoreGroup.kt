package de.jlnstrk.transit.api.hci.model.connection

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.HciCommon
import de.jlnstrk.transit.api.hci.model.message.HciMessage
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciConnectionScoreGroup(
    /** The name of this connection group */
    public val name: String,

    /** The associated icon's index into [HciCommon.icoL] */
    public val icoX: Int,

    /** The id of this connection group */
    public val grpid: String,

    // TODO: Purpose?
    /** Score group requests associated with this group */
    public val requests: List<Request> = emptyList(),

    /** Sub score groups associated with this one */
    public val subL: List<HciConnectionScoreGroup> = emptyList(),

    /** The list of connection scorings part of this group */
    public val conScoringL: List<HciConnectionScoring> = emptyList(),

    /** The type of the principal scoring of this group */
    public val initScoringType: HciConnectionScoring.Type,

    /** Whether this connection group is scrollable */
    public val scrollable: Boolean,

    // TODO: Purpose?
    public val bitmask: Int?,

    /** The messages associated with this scoring */
    public val msgL: List<HciMessage> = emptyList(),
) {

    @Serializable
    public data class Request(
        public val id: String,
        public val autosend: Boolean
    )
}