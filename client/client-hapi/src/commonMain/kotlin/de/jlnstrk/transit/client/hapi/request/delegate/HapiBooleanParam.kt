package de.jlnstrk.transit.client.hapi.request.delegate

internal object HapiBooleanParam : HapiQueryParam<Boolean>(
    serialize = Boolean::toString,
    deserialize = String::toBoolean
)