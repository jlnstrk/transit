package de.jlnstrk.transit.client.hci.method.feedbacksearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.feedback.HciFeedback
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciFeedbackSearchServiceResult(
  public val feedbackL: List<HciFeedback> = emptyList(),
  public val userL: List<HciUser> = emptyList(),
) : HciServiceResult()
