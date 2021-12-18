package de.jlnstrk.transit.interop.efa

import de.jlnstrk.transit.client.efa.EfaClient
import de.jlnstrk.transit.common.Service

internal abstract class EfaService(
    provider: EfaProvider,
    protected val client: EfaClient
) : Service.Implementation<EfaProvider>(provider)