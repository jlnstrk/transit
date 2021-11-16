package de.jlnstrk.transit.interop.hapi

import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.util.Service

internal abstract class HapiService(
    provider: HapiProvider,
    protected val endpoint: HapiEndpoint
) : Service.Base<HapiProvider>(provider)