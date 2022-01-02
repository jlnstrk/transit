package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrType {
  DETAILS_CONNECTION,
  DETAILS_INTERVAL,
  DETAILS_JOURNEY,
  FEED_RSS,
  FEED_TWITTER,
  INCOMP,
  STATISTICS_LINE,
  STATISTICS_ORGANISATION,
  STATISTICS_REGION,
  STATISTICS_ROUTE,
  STATISTICS_STOP,
  UNDEF,
}
