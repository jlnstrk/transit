package de.jlnstrk.transit.client.hapi.request.delegate

internal object HapiStringParam : HapiQueryParam<String>({ it }, { it })