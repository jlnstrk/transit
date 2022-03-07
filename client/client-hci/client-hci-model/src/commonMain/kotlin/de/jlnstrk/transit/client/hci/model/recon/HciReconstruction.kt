package de.jlnstrk.transit.client.hci.model.recon

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.serializer.HciLocalDateSerializer
import de.jlnstrk.transit.util.LocalDate
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciReconstruction(
  public val conId: String? = null,
  public val ctx: String? = null,
  @Serializable(with = HciLocalDateSerializer::class)
  public val date: LocalDate? = null,
  public val secDataL: List<HciReconstructionSectionData> = emptyList(),
  public val rBhv: HciReconstructionBehaviour = HciReconstructionBehaviour.OC
)
