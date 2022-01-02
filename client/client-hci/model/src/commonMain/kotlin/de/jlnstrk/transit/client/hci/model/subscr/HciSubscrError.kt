package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrError {
  BAD_USER_INPUT,
  DUPLICATE_ADDRESS,
  INCOMP,
  INTERNAL_REQUEST_FAILED,
  INTERNAL_TIMEOUT,
  NOT_FOUND_IN_DATA,
  NO_SUCH_CHANNEL,
  NO_SUCH_SUBSCRIPTION,
  NO_SUCH_USER,
  TECHNICAL_ERROR,
  TOO_MANY_SUBSCRIPTIONS,
  UNDEF,
}
