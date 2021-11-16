package de.jlnstrk.transit.api.hapi.request.base

public data class HapiFilterList(
    public val included: List<String> = emptyList(),
    public val excluded: List<String> = emptyList(),
)