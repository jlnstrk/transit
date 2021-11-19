package de.jlnstrk.transit.api.hapi.request.delegate

internal object HapiStringListParam : HapiQueryParam<List<String>>(
    serialize = { it.joinToString(separator = ",") },
    deserialize = { it.split(",") }
)