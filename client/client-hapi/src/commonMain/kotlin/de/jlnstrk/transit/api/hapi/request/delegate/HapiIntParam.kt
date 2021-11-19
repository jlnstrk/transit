package de.jlnstrk.transit.api.hapi.request.delegate

internal object HapiIntParam : HapiQueryParam<Int>(Int::toString, String::toInt)