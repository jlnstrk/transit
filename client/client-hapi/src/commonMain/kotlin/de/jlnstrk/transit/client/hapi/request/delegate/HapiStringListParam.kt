package de.jlnstrk.transit.client.hapi.request.delegate

internal object HapiStringListParam : HapiQueryParam<List<String>>(
    serialize = { it.joinToString(separator = ",") },
    deserialize = { it.split(",") }
)