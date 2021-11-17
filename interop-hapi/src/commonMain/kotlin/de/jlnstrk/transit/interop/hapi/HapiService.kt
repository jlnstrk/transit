package de.jlnstrk.transit.interop.hapi

import de.jlnstrk.transit.api.hapi.HapiClient
import de.jlnstrk.transit.util.Service

internal abstract class HapiService(
    provider: HapiProvider,
    protected val endpoint: HapiClient
) : Service.Base<HapiProvider>(provider)