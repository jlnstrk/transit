package de.jlnstrk.transit.api.hci.response

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public enum class HciServiceError {
    ARRIVAL,
    CGI_CON_REQUEST_FAILED,
    CGI_NO_RESPONSE,
    CGI_NO_SERVER,
    CGI_READ_FAILED,
    CGI_SEND_FAILED,
    CGI_SERVER_OVERLOAD,
    CONTEXT,
    COORDSYSTEM,
    DATE_TIME,
    DEPARTURE,

    /** HCI Service: request failed */
    FAIL,

    /** Departure/Arrival replaced by an equivalent station */
    @SerialName("H390")
    DEP_ARR_REPLACED,

    /** Display may be incomplete due to change of timetable */
    @SerialName("H410")
    DISPLAY_INCOMPLETE,

    /** Prolonged stop */
    @SerialName("H455")
    PROLONGED_STOP,

    // TODO: Meaning?
    H456,

    /** One or more stops are passed through multiple times. */
    @SerialName("H460")
    DUPLICATE_PASSING,

    // TODO: Meaning?
    H480,

    // TODO: Meaning?
    H481,

    // TODO: Meaning?
    H482,

    /** Because of too many trains the connection is not complete */
    @SerialName("H500")
    INCOMPLETE_TOO_MANY_TRAINS,

    // TODO: Meaning?
    H510,

    @SerialName("H886")
    NO_CONNECTIONS_IN_INTERVAL,

    @SerialName("H887")
    COMPUTATION_TIME_LIMIT,

    // TODO: Meaning?
    H888,

    // TODO: Meaning?
    H889,

    @SerialName("H890")
    NO_TRIPS,

    // TODO: Meaning? Obviously related to H890
    H890_1,

    // TODO: Meaning? Obviously related to H890
    H890_2,

    @SerialName("H891")
    NO_ROUTE,

    @SerialName("H892")
    TOO_COMPLEX,

    @SerialName("H895")
    TOO_NEAR,

    /** Unsuccessful or incomplete search (timetable change) */
    @SerialName("H899")
    UNSUCCESSFUL_INCOMPLETE_1,

    /** Unsuccessful or incomplete search (timetable change) */
    @SerialName("H900")
    UNSUCCESSFUL_INCOMPLETE_2,

    // TODO: Meaning? Obviously related to H900
    H900_1,

    // TODO: Meaning? Obviously related to H900
    H900_2,

    // TODO: Meaning?
    H901,

    /** Nearby to the given address stations could not be found */
    @SerialName("H9220")
    NO_STATIONS_NEARBY,

    /** An internal error occured */
    @SerialName("H9230")
    INTERNAL_ERROR,

    /** Unsuccessful search */
    @SerialName("H9240")
    UNSUCCESSFUL_SEARCH,

    /** Part inquiry interrupted */
    @SerialName("H9250")
    INQUIRY_INTERRUPTED,

    /** Unknown departure station */
    @SerialName("H9260")
    UNKNOWN_DEPARTURE_STATION,

    /** Unknown intermediate station */
    @SerialName("H9280")
    UNKNOWN_INTERMEDIATE_STATION,

    /** Unknown arrival station */
    @SerialName("H9300")
    UNKNOWN_ARRIVAL_STATION,

    /** The input is incorrect or incomplete */
    @SerialName("H9320")
    INPUT_INCOMPLETE,

    /** Error in data field */
    @SerialName("H9360")
    DATE_OUT_OF_RANGE,

    /** Dep./Arr./Intermed. or equivalent stations defined more than once */
    @SerialName("H9380")
    LOCATION_DUPLICATE,

    // TODO: Meaning?
    H9400,

    /** Unknown internal error */
    H_UNKNOWN,
    INVALID_CAPTCHA_TOKEN,
    LANGUAGE,
    LAYER,

    /**
     * 1. Location/stop not found
     * 2. HCI Service: location missing or invalid
     * */
    LOCATION,
    LOCATIONS_TOO_CLOSE,

    /** Livesearch: before allowed period */
    LS_EARLY,

    LS_LATE,
    MAIL_RECEIVER,
    MAIL_SENDER,
    MAIL_TRANSFER,
    MEMORY,
    METHOD,
    METHOD_NA,
    NETWORK,

    /** Nothing found */
    NO_MATCH,
    NULLPTR,
    OK,
    OUT_OF_REGION,
    PARAMETER,
    PROBLEMS,
    P_BITFIELD,
    SEINT,
    SEJC,
    SEJPE,
    SEJPL,
    SEML,
    SEPREBOOK,
    SESPE,
    SESPL,
    SMS_NUMBER,
    SMS_TRANSFER,
    SOT_AT_DEST,
    SOT_BEFORE_START,
    SOT_CANCELLED,
    TARIFF,
    TOO_MANY,
    UNDEF,
}