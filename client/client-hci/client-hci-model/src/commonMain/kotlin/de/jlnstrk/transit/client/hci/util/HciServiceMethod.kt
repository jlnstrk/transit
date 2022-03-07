package de.jlnstrk.transit.client.hci.util

import de.jlnstrk.transit.client.hci.method.bookingassortment.HciBookingAssortmentServiceResult
import de.jlnstrk.transit.client.hci.method.bookingdata.HciBookingDataServiceResult
import de.jlnstrk.transit.client.hci.method.bookingvalidation.HciBookingValidationServiceResult
import de.jlnstrk.transit.client.hci.method.chatmessagesearch.HciChatMessageSearchServiceResult
import de.jlnstrk.transit.client.hci.method.chatmessagestore.HciChatMessageStoreServiceResult
import de.jlnstrk.transit.client.hci.method.checkinjourneysearch.HciCheckInJourneySearchServiceResult
import de.jlnstrk.transit.client.hci.method.checkinjourneystore.HciCheckInJourneyStoreServiceResult
import de.jlnstrk.transit.client.hci.method.checkinlocationsearch.HciCheckInLocationSearchServiceResult
import de.jlnstrk.transit.client.hci.method.checkinlocationstore.HciCheckInLocationStoreServiceResult
import de.jlnstrk.transit.client.hci.method.checkintripsearch.HciCheckInTripSearchServiceResult
import de.jlnstrk.transit.client.hci.method.checkintripstore.HciCheckInTripStoreServiceResult
import de.jlnstrk.transit.client.hci.method.eventlocgeopos.HciEventLocGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.feedbackmail.HciFeedbackMailServiceResult
import de.jlnstrk.transit.client.hci.method.feedbacksearch.HciFeedbackSearchServiceResult
import de.jlnstrk.transit.client.hci.method.feedbackstore.HciFeedbackStoreServiceResult
import de.jlnstrk.transit.client.hci.method.geofeaturedetails.HciGeoFeatureDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.geofeaturegeopos.HciGeoFeatureGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.gisroute.HciGisRouteServiceResult
import de.jlnstrk.transit.client.hci.method.gissearch.HciGisSearchServiceResult
import de.jlnstrk.transit.client.hci.method.graphgeopos.HciGraphGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.himaffect.HciHimAffectServiceResult
import de.jlnstrk.transit.client.hci.method.himdetails.HciHimDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.himgeopos.HciHimGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.himmatch.HciHimMatchServiceResult
import de.jlnstrk.transit.client.hci.method.himsearch.HciHimSearchServiceResult
import de.jlnstrk.transit.client.hci.method.journeycourse.HciJourneyCourseServiceResult
import de.jlnstrk.transit.client.hci.method.journeydetails.HciJourneyDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.journeygeopos.HciJourneyGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.journeygraph.HciJourneyGraphServiceResult
import de.jlnstrk.transit.client.hci.method.journeymatch.HciJourneyMatchServiceResult
import de.jlnstrk.transit.client.hci.method.journeystructgraphpos.HciJourneyStructGraphPosServiceResult
import de.jlnstrk.transit.client.hci.method.journeytrackmatch.HciJourneyTrackMatchServiceResult
import de.jlnstrk.transit.client.hci.method.journeytree.HciJourneyTreeServiceResult
import de.jlnstrk.transit.client.hci.method.linedetails.HciLineDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.linegeopos.HciLineGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchServiceResult
import de.jlnstrk.transit.client.hci.method.linesearch.HciLineSearchServiceResult
import de.jlnstrk.transit.client.hci.method.locdetails.HciLocDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.locgeopos.HciLocGeoPosServiceResult
import de.jlnstrk.transit.client.hci.method.locgeoreach.HciLocGeoReachServiceResult
import de.jlnstrk.transit.client.hci.method.locgraph.HciLocGraphServiceResult
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceResult
import de.jlnstrk.transit.client.hci.method.locsearch.HciLocSearchServiceResult
import de.jlnstrk.transit.client.hci.method.locwalkdetails.HciLocWalkDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.locwalksearch.HciLocWalkSearchServiceResult
import de.jlnstrk.transit.client.hci.method.matchme.HciMatchMeServiceResult
import de.jlnstrk.transit.client.hci.method.notificationsearch.HciNotificationSearchServiceResult
import de.jlnstrk.transit.client.hci.method.notificationstore.HciNotificationStoreServiceResult
import de.jlnstrk.transit.client.hci.method.onefieldsearch.HciOneFieldSearchServiceResult
import de.jlnstrk.transit.client.hci.method.partialsearch.HciPartialSearchServiceResult
import de.jlnstrk.transit.client.hci.method.ratingsearch.HciRatingSearchServiceResult
import de.jlnstrk.transit.client.hci.method.ratingstore.HciRatingStoreServiceResult
import de.jlnstrk.transit.client.hci.method.reconstruction.HciReconstructionServiceResult
import de.jlnstrk.transit.client.hci.method.reconstructioncontextconverter.HciReconstructionContextConverterServiceResult
import de.jlnstrk.transit.client.hci.method.searchontrip.HciSearchOnTripServiceResult
import de.jlnstrk.transit.client.hci.method.serverinfo.HciServerInfoServiceResult
import de.jlnstrk.transit.client.hci.method.sharelocation.HciShareLocationServiceResult
import de.jlnstrk.transit.client.hci.method.sharetrip.HciShareTripServiceResult
import de.jlnstrk.transit.client.hci.method.stationboard.HciStationBoardServiceResult
import de.jlnstrk.transit.client.hci.method.structgraph.HciStructGraphServiceResult
import de.jlnstrk.transit.client.hci.method.subscrchannelconfirm.HciSubscrChannelConfirmServiceResult
import de.jlnstrk.transit.client.hci.method.subscrchannelcreate.HciSubscrChannelCreateServiceResult
import de.jlnstrk.transit.client.hci.method.subscrchanneldelete.HciSubscrChannelDeleteServiceResult
import de.jlnstrk.transit.client.hci.method.subscrchannelsenddetails.HciSubscrChannelSendDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.subscrchannelupdate.HciSubscrChannelUpdateServiceResult
import de.jlnstrk.transit.client.hci.method.subscrcreate.HciSubscrCreateServiceResult
import de.jlnstrk.transit.client.hci.method.subscrdelete.HciSubscrDeleteServiceResult
import de.jlnstrk.transit.client.hci.method.subscrdetails.HciSubscrDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.subscrnotification.HciSubscrNotificationServiceResult
import de.jlnstrk.transit.client.hci.method.subscrsearch.HciSubscrSearchServiceResult
import de.jlnstrk.transit.client.hci.method.subscrstatus.HciSubscrStatusServiceResult
import de.jlnstrk.transit.client.hci.method.subscrupdate.HciSubscrUpdateServiceResult
import de.jlnstrk.transit.client.hci.method.subscrusercreate.HciSubscrUserCreateServiceResult
import de.jlnstrk.transit.client.hci.method.subscruserdelete.HciSubscrUserDeleteServiceResult
import de.jlnstrk.transit.client.hci.method.subscruserdetails.HciSubscrUserDetailsServiceResult
import de.jlnstrk.transit.client.hci.method.subscruserupdate.HciSubscrUserUpdateServiceResult
import de.jlnstrk.transit.client.hci.method.subscrvalidate.HciSubscrValidateServiceResult
import de.jlnstrk.transit.client.hci.method.tariffsearch.HciTariffSearchServiceResult
import de.jlnstrk.transit.client.hci.method.tripsearch.HciTripSearchServiceResult
import de.jlnstrk.transit.client.hci.method.userlogin.HciUserLoginServiceResult
import de.jlnstrk.transit.client.hci.method.usersearch.HciUserSearchServiceResult
import de.jlnstrk.transit.client.hci.method.userstore.HciUserStoreServiceResult
import de.jlnstrk.transit.client.hci.model.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlin.UnsupportedOperationException
import kotlin.reflect.KClass

public val HciServiceMethod.resultType: KClass<out HciServiceResult>
  get() = when (this) {
    HciServiceMethod.BOOKING_ASSORTMENT -> HciBookingAssortmentServiceResult::class
    HciServiceMethod.BOOKING_DATA -> HciBookingDataServiceResult::class
    HciServiceMethod.BOOKING_VALIDATION -> HciBookingValidationServiceResult::class
    HciServiceMethod.CHAT_MESSAGE_SEARCH -> HciChatMessageSearchServiceResult::class
    HciServiceMethod.CHAT_MESSAGE_STORE -> HciChatMessageStoreServiceResult::class
    HciServiceMethod.CHECK_IN_JOURNEY_SEARCH -> HciCheckInJourneySearchServiceResult::class
    HciServiceMethod.CHECK_IN_JOURNEY_STORE -> HciCheckInJourneyStoreServiceResult::class
    HciServiceMethod.CHECK_IN_LOCATION_SEARCH -> HciCheckInLocationSearchServiceResult::class
    HciServiceMethod.CHECK_IN_LOCATION_STORE -> HciCheckInLocationStoreServiceResult::class
    HciServiceMethod.CHECK_IN_TRIP_SEARCH -> HciCheckInTripSearchServiceResult::class
    HciServiceMethod.CHECK_IN_TRIP_STORE -> HciCheckInTripStoreServiceResult::class
    HciServiceMethod.EVENT_LOC_GEO_POS -> HciEventLocGeoPosServiceResult::class
    HciServiceMethod.FEEDBACK_MAIL -> HciFeedbackMailServiceResult::class
    HciServiceMethod.FEEDBACK_SEARCH -> HciFeedbackSearchServiceResult::class
    HciServiceMethod.FEEDBACK_STORE -> HciFeedbackStoreServiceResult::class
    HciServiceMethod.FEEDER_BOARD -> throw UnsupportedOperationException()
    HciServiceMethod.FETCHER_BOARD -> throw UnsupportedOperationException()
    HciServiceMethod.GEO_FEATURE_DETAILS -> HciGeoFeatureDetailsServiceResult::class
    HciServiceMethod.GEO_FEATURE_GEO_POS -> HciGeoFeatureGeoPosServiceResult::class
    HciServiceMethod.GIS_ROUTE -> HciGisRouteServiceResult::class
    HciServiceMethod.GIS_SEARCH -> HciGisSearchServiceResult::class
    HciServiceMethod.GRAPH_GEO_POS -> HciGraphGeoPosServiceResult::class
    HciServiceMethod.HIM_AFFECT -> HciHimAffectServiceResult::class
    HciServiceMethod.HIM_DETAILS -> HciHimDetailsServiceResult::class
    HciServiceMethod.HIM_GEO_POS -> HciHimGeoPosServiceResult::class
    HciServiceMethod.HIM_MATCH -> HciHimMatchServiceResult::class
    HciServiceMethod.HIM_SEARCH -> HciHimSearchServiceResult::class
    HciServiceMethod.JOURNEY_COURSE -> HciJourneyCourseServiceResult::class
    HciServiceMethod.JOURNEY_DETAILS -> HciJourneyDetailsServiceResult::class
    HciServiceMethod.JOURNEY_GEO_POS -> HciJourneyGeoPosServiceResult::class
    HciServiceMethod.JOURNEY_GRAPH -> HciJourneyGraphServiceResult::class
    HciServiceMethod.JOURNEY_MATCH -> HciJourneyMatchServiceResult::class
    HciServiceMethod.JOURNEY_STRUCT_GRAPH_POS -> HciJourneyStructGraphPosServiceResult::class
    HciServiceMethod.JOURNEY_TRACK_MATCH -> HciJourneyTrackMatchServiceResult::class
    HciServiceMethod.JOURNEY_TREE -> HciJourneyTreeServiceResult::class
    HciServiceMethod.LINE_DETAILS -> HciLineDetailsServiceResult::class
    HciServiceMethod.LINE_GEO_POS -> HciLineGeoPosServiceResult::class
    HciServiceMethod.LINE_MATCH -> HciLineMatchServiceResult::class
    HciServiceMethod.LINE_SEARCH -> HciLineSearchServiceResult::class
    HciServiceMethod.LOC_DETAILS -> HciLocDetailsServiceResult::class
    HciServiceMethod.LOC_GEO_POS -> HciLocGeoPosServiceResult::class
    HciServiceMethod.LOC_GEO_REACH -> HciLocGeoReachServiceResult::class
    HciServiceMethod.LOC_GRAPH -> HciLocGraphServiceResult::class
    HciServiceMethod.LOC_MATCH -> HciLocMatchServiceResult::class
    HciServiceMethod.LOC_SEARCH -> HciLocSearchServiceResult::class
    HciServiceMethod.LOC_WALK_DETAILS -> HciLocWalkDetailsServiceResult::class
    HciServiceMethod.LOC_WALK_SEARCH -> HciLocWalkSearchServiceResult::class
    HciServiceMethod.MATCH_ME -> HciMatchMeServiceResult::class
    HciServiceMethod.NOTIFICATION_SEARCH -> HciNotificationSearchServiceResult::class
    HciServiceMethod.NOTIFICATION_STORE -> HciNotificationStoreServiceResult::class
    HciServiceMethod.ONE_FIELD_SEARCH -> HciOneFieldSearchServiceResult::class
    HciServiceMethod.PARTIAL_SEARCH -> HciPartialSearchServiceResult::class
    HciServiceMethod.RATING_SEARCH -> HciRatingSearchServiceResult::class
    HciServiceMethod.RATING_STORE -> HciRatingStoreServiceResult::class
    HciServiceMethod.RECONSTRUCTION -> HciReconstructionServiceResult::class
    HciServiceMethod.RECONSTRUCTION_CONTEXT_CONVERTER ->
        HciReconstructionContextConverterServiceResult::class
    HciServiceMethod.SEARCH_ON_TRIP -> HciSearchOnTripServiceResult::class
    HciServiceMethod.SERVER_INFO -> HciServerInfoServiceResult::class
    HciServiceMethod.SHARE_LOCATION -> HciShareLocationServiceResult::class
    HciServiceMethod.SHARE_TRIP -> HciShareTripServiceResult::class
    HciServiceMethod.STATION_BOARD -> HciStationBoardServiceResult::class
    HciServiceMethod.STRUCT_GRAPH -> HciStructGraphServiceResult::class
    HciServiceMethod.SUBSCR_CHANNEL_CONFIRM -> HciSubscrChannelConfirmServiceResult::class
    HciServiceMethod.SUBSCR_CHANNEL_CREATE -> HciSubscrChannelCreateServiceResult::class
    HciServiceMethod.SUBSCR_CHANNEL_DELETE -> HciSubscrChannelDeleteServiceResult::class
    HciServiceMethod.SUBSCR_CHANNEL_SEND_DETAILS -> HciSubscrChannelSendDetailsServiceResult::class
    HciServiceMethod.SUBSCR_CHANNEL_UPDATE -> HciSubscrChannelUpdateServiceResult::class
    HciServiceMethod.SUBSCR_CREATE -> HciSubscrCreateServiceResult::class
    HciServiceMethod.SUBSCR_DELETE -> HciSubscrDeleteServiceResult::class
    HciServiceMethod.SUBSCR_DETAILS -> HciSubscrDetailsServiceResult::class
    HciServiceMethod.SUBSCR_NOTIFICATION -> HciSubscrNotificationServiceResult::class
    HciServiceMethod.SUBSCR_SEARCH -> HciSubscrSearchServiceResult::class
    HciServiceMethod.SUBSCR_STATUS -> HciSubscrStatusServiceResult::class
    HciServiceMethod.SUBSCR_UPDATE -> HciSubscrUpdateServiceResult::class
    HciServiceMethod.SUBSCR_USER_CREATE -> HciSubscrUserCreateServiceResult::class
    HciServiceMethod.SUBSCR_USER_DELETE -> HciSubscrUserDeleteServiceResult::class
    HciServiceMethod.SUBSCR_USER_DETAILS -> HciSubscrUserDetailsServiceResult::class
    HciServiceMethod.SUBSCR_USER_UPDATE -> HciSubscrUserUpdateServiceResult::class
    HciServiceMethod.SUBSCR_VALIDATE -> HciSubscrValidateServiceResult::class
    HciServiceMethod.TARIFF_SEARCH -> HciTariffSearchServiceResult::class
    HciServiceMethod.TRIP_SEARCH -> HciTripSearchServiceResult::class
    HciServiceMethod.USER_LOGIN -> HciUserLoginServiceResult::class
    HciServiceMethod.USER_SEARCH -> HciUserSearchServiceResult::class
    HciServiceMethod.USER_STORE -> HciUserStoreServiceResult::class
  }
