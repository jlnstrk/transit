package de.jlnstrk.transit.client.hci.method.himmatch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciOperator
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchAffectedRegion
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchAffectedRoute
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchError
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchJourney
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchLine
import de.jlnstrk.transit.client.hci.model.him.HciHimMatchWarning
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciHimMatchServiceResult(
  public val common: HciCommon? = null,
  public val affOpL: List<HciOperator> = emptyList(),
  public val affRegL: List<HciHimMatchAffectedRegion> = emptyList(),
  public val affRouteL: List<HciHimMatchAffectedRoute> = emptyList(),
  public val affStL: List<HciLocation> = emptyList(),
  public val lineL: List<HciHimMatchLine> = emptyList(),
  public val matchErrL: List<HciHimMatchError> = emptyList(),
  public val matchJnyL: List<HciHimMatchJourney> = emptyList(),
  public val matchWarnL: List<HciHimMatchWarning> = emptyList(),
  public val trainNameL: List<String> = emptyList(),
  public val numOfHimJrnRes: Int = 0,
  public val numOfRes: Int = 0
) : HciServiceResult()
