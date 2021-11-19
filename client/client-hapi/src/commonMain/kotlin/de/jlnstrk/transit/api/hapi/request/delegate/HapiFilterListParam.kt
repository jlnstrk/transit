package de.jlnstrk.transit.api.hapi.request.delegate

import de.jlnstrk.transit.api.hapi.request.base.HapiFilterList

internal object HapiFilterListParam : HapiQueryParam<HapiFilterList>(
    serialize = {  (it.included + it.excluded.map { exclude -> "!$exclude" }).joinToString(separator = ",") },
    deserialize = {
        val entries = it.split(",")
        val included = mutableListOf<String>()
        val excluded = mutableListOf<String>()
        for (entry in entries) {
            if (entry[0] == '!') {
                excluded.add(entry)
            } else {
                included.add(entry)
            }
        }
        HapiFilterList(included, excluded)
    }
)