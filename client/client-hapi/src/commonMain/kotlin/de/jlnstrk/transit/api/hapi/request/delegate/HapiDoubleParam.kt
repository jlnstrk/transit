package de.jlnstrk.transit.api.hapi.request.delegate

internal object HapiDoubleParam : HapiQueryParam<Double>(Double::toString, String::toDouble)