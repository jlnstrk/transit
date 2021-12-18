package de.jlnstrk.transit.client.hapi.request.base

public data class HapiFilterList(
    public val included: List<String> = emptyList(),
    public val excluded: List<String> = emptyList(),
)