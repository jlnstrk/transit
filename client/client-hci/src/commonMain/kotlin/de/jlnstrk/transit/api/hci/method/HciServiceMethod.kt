package de.jlnstrk.transit.api.hci.method

import de.jlnstrk.transit.api.hafas.HciModel
import de.jlnstrk.transit.api.hci.method.himsearch.HciHimSearchResult
import de.jlnstrk.transit.api.hci.method.journeycourse.HciJourneyCourseResult
import de.jlnstrk.transit.api.hci.method.journeydetails.HciJourneyDetailsResult
import de.jlnstrk.transit.api.hci.method.journeygeopos.HciJourneyGeoPosResult
import de.jlnstrk.transit.api.hci.method.journeymatch.HciJourneyMatchResult
import de.jlnstrk.transit.api.hci.method.linematch.HciLineMatchResult
import de.jlnstrk.transit.api.hci.method.locdetails.HciLocDetailsResult
import de.jlnstrk.transit.api.hci.method.locgeopos.HciLocGeoPosResult
import de.jlnstrk.transit.api.hci.method.locgeoreach.HciLocGeoReachResult
import de.jlnstrk.transit.api.hci.method.locgraph.HciLocGraphResult
import de.jlnstrk.transit.api.hci.method.locmatch.HciLocMatchResult
import de.jlnstrk.transit.api.hci.method.locsearch.HciLocSearchResult
import de.jlnstrk.transit.api.hci.method.locwalkdetails.HciLocWalkDetailsResult
import de.jlnstrk.transit.api.hci.method.locwalksearch.HciLocWalkSearchResult
import de.jlnstrk.transit.api.hci.method.reconstruction.HciReconstructionResult
import de.jlnstrk.transit.api.hci.method.serverinfo.HciServerInfoResult
import de.jlnstrk.transit.api.hci.method.stationboard.HciStationBoardResult
import de.jlnstrk.transit.api.hci.method.tripsearch.HciTripSearchResult
import de.jlnstrk.transit.api.hci.response.HciServiceResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@HciModel("1.39")
@Serializable
public enum class HciServiceMethod(
    internal val responseType: KClass<out HciServiceResult>? = null
) {
    @SerialName("BookingAssortment")
    BOOKING_ASSORTMENT,

    @SerialName("BookingData")
    BOOKING_DATA,

    @SerialName("BookingValidation")
    BOOKING_VALIDATION,

    @SerialName("ChatMessageSearch")
    CHAT_MESSAGE_SEARCH,

    @SerialName("ChatMessageStore")
    CHAT_MESSAGE_STORE,

    @SerialName("CheckInJourneySearch")
    CHECK_IN_JOURNEY_SEARCH,

    @SerialName("CheckInJourneyStore")
    CHECK_IN_JOURNEY_STORE,

    @SerialName("CheckInLocationSearch")
    CHECK_IN_LOCATION_SEARCH,

    @SerialName("CheckInLocationStore")
    CHECK_IN_LOCATION_STORE,

    @SerialName("CheckInTripSearch")
    CHECK_IN_TRIP_SEARCH,

    @SerialName("CheckInTripStore")
    CHECK_IN_TRIP_STORE,

    @SerialName("FeedbackMail")
    FEEDBACK_MAIL,

    @SerialName("FeedbackSearch")
    FEEDBACK_SEARCH,

    @SerialName("FeedbackStore")
    FEEDBACK_STORE,

    @SerialName("FeederBoard")
    FEEDER_BOARD,

    @SerialName("FetcherBoard")
    FETCHER_BOARD,

    @SerialName("GisRoute")
    GIS_ROUTE,

    @SerialName("GraphGeoPos")
    GRAPH_GEO_POS,

    @SerialName("HimAffect")
    HIM_AFFECT,

    @SerialName("HimDetails")
    HIM_DETAILS,

    @SerialName("HimGeoPos")
    HIM_GEO_POS,

    @SerialName("HimMatch")
    HIM_MATCH,

    @SerialName("HimSearch")
    HIM_SEARCH(HciHimSearchResult::class),

    @SerialName("JourneyCourse")
    JOURNEY_COURSE(HciJourneyCourseResult::class),

    @SerialName("JourneyDetails")
    JOURNEY_DETAILS(HciJourneyDetailsResult::class),

    @SerialName("JourneyGeoPos")
    JOURNEY_GEO_POS(HciJourneyGeoPosResult::class),

    @SerialName("JourneyGraph")
    JOURNEY_GRAPH,

    @SerialName("JourneyMatch")
    JOURNEY_MATCH(HciJourneyMatchResult::class),

    @SerialName("JourneyStructGraphPos")
    JOURNEY_STRUCT_GRAPH_POS,

    @SerialName("JourneyTrackMatch")
    JOURNEY_TRACK_MATCH,

    @SerialName("JourneyTree")
    JOURNEY_TREE,

    @SerialName("LineDetails")
    LINE_DETAILS,

    @SerialName("LineGeoPos")
    LINE_GEO_POS,

    @SerialName("LineMatch")
    LINE_MATCH(HciLineMatchResult::class),

    @SerialName("LineSearch")
    LINE_SEARCH,

    @SerialName("LocDetails")
    LOC_DETAILS(HciLocDetailsResult::class),

    @SerialName("LocGeoPos")
    LOC_GEO_POS(HciLocGeoPosResult::class),

    @SerialName("LocGeoReach")
    LOC_GEO_REACH(HciLocGeoReachResult::class),

    @SerialName("LocGraph")
    LOC_GRAPH(HciLocGraphResult::class),

    @SerialName("LocMatch")
    LOC_MATCH(HciLocMatchResult::class),

    @SerialName("LocSearch")
    LOC_SEARCH(HciLocSearchResult::class),

    @SerialName("LocWalkDetails")
    LOC_WALK_DETAILS(HciLocWalkDetailsResult::class),

    @SerialName("LocWalkSearch")
    LOC_WALK_SEARCH(HciLocWalkSearchResult::class),

    @SerialName("MatchMe")
    MATCH_ME,

    @SerialName("NotificationSearch")
    NOTIFICATION_SEARCH,

    @SerialName("NotificationStore")
    NOTIFICATION_STORE,

    @SerialName("OneFieldSearch")
    ONE_FIELD_SEARCH,

    @SerialName("PartialSearch")
    PARTIAL_SEARCH,

    @SerialName("RatingSearch")
    RATING_SEARCH,

    @SerialName("RatingStore")
    RATING_STORE,

    @SerialName("Reconstruction")
    RECONSTRUCTION(HciReconstructionResult::class),

    @SerialName("SearchOnTrip")
    SEARCH_ON_TRIP,

    @SerialName("ServerInfo")
    SERVER_INFO(HciServerInfoResult::class),

    @SerialName("ShareTrip")
    SHARE_TRIP,

    @SerialName("ShareLoc")
    SHARE_LOC,

    @SerialName("StationBoard")
    STATION_BOARD(HciStationBoardResult::class),

    @SerialName("StructGraph")
    STRUCT_GRAPH,

    @SerialName("SubscrChannelConfirm")
    SUBSCRIPTION_CHANNEL_CONFIRM,

    @SerialName("SubscrChannelCreate")
    SUBSCRIPTION_CHANNEL_CREATE,

    @SerialName("SubscrChannelDelete")
    SUBSCRIPTION_CHANNEL_DELETE,

    @SerialName("SubscrChannelSendDetails")
    SUBSCRIPTION_CHANNEL_SEND_DETAILS,

    @SerialName("SubscrChannelUpdate")
    SUBSCRIPTION_CHANNEL_UPDATE,

    @SerialName("SubscrCreate")
    SUBSCRIPTION_CREATE,

    @SerialName("SubscrDelete")
    SUBSCRIPTION_DELETE,

    @SerialName("SubscrDetails")
    SUBSCRIPTION_DETAILS,

    @SerialName("SubscrNotification")
    SUBSCRIPTION_NOTIFICATION,

    @SerialName("SubscrSearch")
    SUBSCRIPTION_SEARCH,

    @SerialName("SubscrStatus")
    SUBSCRIPTION_STATUS,

    @SerialName("SubscrUpdate")
    SUBSCRIPTION_UPDATE,

    @SerialName("SubscrUserCreate")
    SUBSCRIPTION_USER_CREATE,

    @SerialName("SubscrUserDelete")
    SUBSCRIPTION_USER_DELETE,

    @SerialName("SubscrUserDetails")
    SUBSCRIPTION_USER_DETAILS,

    @SerialName("SubscrUserUpdate")
    SUBSCRIPTION_USER_UPDATE,

    @SerialName("SubscrValidate")
    SUBSCRIPTION_VALIDATE,

    @SerialName("TariffSearch")
    TARIFF_SEARCH,

    @SerialName("TripSearch")
    TRIP_SEARCH(HciTripSearchResult::class),

    @SerialName("UserLogin")
    USER_LOGIN,

    @SerialName("UserSearch")
    USER_SEARCH,

    @SerialName("UserStore")
    USER_STORE,
}