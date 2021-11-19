package de.jlnstrk.transit.api.hapi.request.delegate

internal object HapiStringParam : HapiQueryParam<String>({ it }, { it })