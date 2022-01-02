package de.jlnstrk.transit.client.hci.method.reconstructioncontextconverter

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciReconstructionContextConverterServiceResult(
  public val ctxL: List<String> = emptyList()
) : HciServiceResult()
