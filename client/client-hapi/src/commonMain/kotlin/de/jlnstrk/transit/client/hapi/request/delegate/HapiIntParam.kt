package de.jlnstrk.transit.client.hapi.request.delegate

internal object HapiIntParam : HapiQueryParam<Int>(Int::toString, String::toInt)