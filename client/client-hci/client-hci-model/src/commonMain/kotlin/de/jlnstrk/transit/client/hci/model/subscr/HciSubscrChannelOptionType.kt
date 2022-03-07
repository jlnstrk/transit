package de.jlnstrk.transit.client.hci.model.subscr

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciSubscrChannelOptionType {
  CUSTOMER_TYPE,
  FIRSTNAME,
  INCOMP,
  LASTNAME,
  NO_SOUND,
  QUERY_LINK_PARAMS,
  REFID,
  SALUTATION,
  SILENT,
  TEXT,
  TITLE,
  UNDEF,
  URL_OBSERVATION_END,
  URL_PLANDATA_CHANGED,
  URL_REALTIME_EVENT,
}
