package de.jlnstrk.transit.client.hci.modelsync

data class HciModelRepresentation(
    val hciVersion: String?,
    val types: List<HciTypeRepresentation>
)