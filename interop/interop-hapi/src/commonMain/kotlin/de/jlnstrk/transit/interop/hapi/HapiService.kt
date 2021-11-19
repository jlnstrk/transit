package de.jlnstrk.transit.interop.hapi

import de.jlnstrk.transit.api.hapi.HapiClient
import de.jlnstrk.transit.common.Service

internal abstract class HapiService(
    provider: HapiProvider,
    protected val endpoint: HapiClient
) : Service.Implementation<HapiProvider>(provider)