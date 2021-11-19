package de.jlnstrk.transit.api.hapi.base

import de.jlnstrk.transit.api.hapi.HapiClient
import de.jlnstrk.transit.util.testing.ProfileDataShouldSpec

internal typealias HapiShouldSpec = ProfileDataShouldSpec<HapiClient, HapiTestProfile>