package de.jlnstrk.transit.client.hci.method.subscrvalidate

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrBadServiceDay
import de.jlnstrk.transit.client.hci.model.subscr.HciSubscrResultStatus
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciSubscrValidateServiceResult(
  public val badServiceDays: List<HciSubscrBadServiceDay> = emptyList(),
  public val result: HciSubscrResultStatus
) : HciServiceResult()
