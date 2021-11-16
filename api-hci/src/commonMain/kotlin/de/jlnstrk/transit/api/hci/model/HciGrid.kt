package de.jlnstrk.transit.api.hci.model

import kotlinx.serialization.Serializable

@Serializable
public data class HciGrid(
    private val type: ContentType,
    private val title: String,
    private val nCols: Int,
    private val nRows: Int,
    private var itemL: List<HciGridItem> = emptyList(),
) {

    @Serializable
    public enum class ContentType {
        // TODO: Meaning?
        G,

        // TODO: Meaning?
        OH,

        // TODO: Meaning?
        S
    }
}