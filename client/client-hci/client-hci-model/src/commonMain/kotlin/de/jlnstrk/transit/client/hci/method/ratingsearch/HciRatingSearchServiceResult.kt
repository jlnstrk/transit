package de.jlnstrk.transit.client.hci.method.ratingsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciCommon
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import de.jlnstrk.transit.client.hci.model.rating.HciRating
import de.jlnstrk.transit.client.hci.model.user.HciUser
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciRatingSearchServiceResult(
  public val common: HciCommon? = null,
  public val ratingL: List<HciRating> = emptyList(),
  public val userL: List<HciUser> = emptyList()
) : HciServiceResult()