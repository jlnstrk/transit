package de.jlnstrk.transit.interop.efa

import de.jlnstrk.transit.api.efa.EfaEndpoint
import de.jlnstrk.transit.util.Service

internal abstract class EfaService(
    provider: EfaProvider,
    protected val endpoint: EfaEndpoint
) : Service.Base<EfaProvider>(provider)