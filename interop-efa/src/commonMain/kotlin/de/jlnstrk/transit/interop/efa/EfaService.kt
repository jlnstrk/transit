package de.jlnstrk.transit.interop.efa

import de.jlnstrk.transit.api.efa.EfaClient
import de.jlnstrk.transit.util.Service

internal abstract class EfaService(
    provider: EfaProvider,
    protected val client: EfaClient
) : Service.Base<EfaProvider>(provider)