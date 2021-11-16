package de.jlnstrk.transit.api.hci.model

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.model.message.HciMessageContent
import de.jlnstrk.transit.api.hci.model.message.HciMessageFormat
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciGridItem(
    private val col: Int,
    private val row: Int,
    private val cntL: Set<HciMessageContent?> = emptySet(),
    private val frmL: Set<HciMessageFormat> = emptySet(),
    private val remL: List<Int> = emptyList(),
    private val txtC: HciColor?,
)