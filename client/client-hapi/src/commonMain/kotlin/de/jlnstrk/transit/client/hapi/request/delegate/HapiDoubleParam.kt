package de.jlnstrk.transit.client.hapi.request.delegate

internal object HapiDoubleParam : HapiQueryParam<Double>(Double::toString, String::toDouble)