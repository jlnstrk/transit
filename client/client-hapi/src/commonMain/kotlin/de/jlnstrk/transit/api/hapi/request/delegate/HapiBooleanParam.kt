package de.jlnstrk.transit.api.hapi.request.delegate

internal object HapiBooleanParam : HapiQueryParam<Boolean>(
    serialize = Boolean::toString,
    deserialize = String::toBoolean
)