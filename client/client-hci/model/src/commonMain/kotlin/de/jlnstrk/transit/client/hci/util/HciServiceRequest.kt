package de.jlnstrk.transit.client.hci.util

import de.jlnstrk.transit.client.hci.method.bookingassortment.HciBookingAssortmentServiceRequest
import de.jlnstrk.transit.client.hci.method.bookingdata.HciBookingDataServiceRequest
import de.jlnstrk.transit.client.hci.method.bookingvalidation.HciBookingValidationServiceRequest
import de.jlnstrk.transit.client.hci.method.chatmessagesearch.HciChatMessageSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.chatmessagestore.HciChatMessageStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.checkinjourneysearch.HciCheckInJourneySearchServiceRequest
import de.jlnstrk.transit.client.hci.method.checkinjourneystore.HciCheckInJourneyStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.checkinlocationsearch.HciCheckInLocationSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.checkinlocationstore.HciCheckInLocationStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.checkintripsearch.HciCheckInTripSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.checkintripstore.HciCheckInTripStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.eventlocgeopos.HciEventLocGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.feedbackmail.HciFeedbackMailServiceRequest
import de.jlnstrk.transit.client.hci.method.feedbacksearch.HciFeedbackSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.feedbackstore.HciFeedbackStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.geofeaturedetails.HciGeoFeatureDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.geofeaturegeopos.HciGeoFeatureGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.gisroute.HciGisRouteServiceRequest
import de.jlnstrk.transit.client.hci.method.gissearch.HciGisSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.graphgeopos.HciGraphGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.himaffect.HciHimAffectServiceRequest
import de.jlnstrk.transit.client.hci.method.himdetails.HciHimDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.himgeopos.HciHimGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.himmatch.HciHimMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.himsearch.HciHimSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.journeycourse.HciJourneyCourseServiceRequest
import de.jlnstrk.transit.client.hci.method.journeydetails.HciJourneyDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.journeygeopos.HciJourneyGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.journeygraph.HciJourneyGraphServiceRequest
import de.jlnstrk.transit.client.hci.method.journeymatch.HciJourneyMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.journeystructgraphpos.HciJourneyStructGraphPosServiceRequest
import de.jlnstrk.transit.client.hci.method.journeytrackmatch.HciJourneyTrackMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.journeytree.HciJourneyTreeServiceRequest
import de.jlnstrk.transit.client.hci.method.linedetails.HciLineDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.linegeopos.HciLineGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.linematch.HciLineMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.linesearch.HciLineSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.locdetails.HciLocDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.locgeopos.HciLocGeoPosServiceRequest
import de.jlnstrk.transit.client.hci.method.locgeoreach.HciLocGeoReachServiceRequest
import de.jlnstrk.transit.client.hci.method.locgraph.HciLocGraphServiceRequest
import de.jlnstrk.transit.client.hci.method.locmatch.HciLocMatchServiceRequest
import de.jlnstrk.transit.client.hci.method.locsearch.HciLocSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.locwalkdetails.HciLocWalkDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.locwalksearch.HciLocWalkSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.matchme.HciMatchMeServiceRequest
import de.jlnstrk.transit.client.hci.method.notificationsearch.HciNotificationSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.notificationstore.HciNotificationStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.onefieldsearch.HciOneFieldSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.partialsearch.HciPartialSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.ratingsearch.HciRatingSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.ratingstore.HciRatingStoreServiceRequest
import de.jlnstrk.transit.client.hci.method.reconstruction.HciReconstructionServiceRequest
import de.jlnstrk.transit.client.hci.method.reconstructioncontextconverter.HciReconstructionContextConverterServiceRequest
import de.jlnstrk.transit.client.hci.method.searchontrip.HciSearchOnTripServiceRequest
import de.jlnstrk.transit.client.hci.method.serverinfo.HciServerInfoServiceRequest
import de.jlnstrk.transit.client.hci.method.sharelocation.HciShareLocationServiceRequest
import de.jlnstrk.transit.client.hci.method.sharetrip.HciShareTripServiceRequest
import de.jlnstrk.transit.client.hci.method.stationboard.HciStationBoardServiceRequest
import de.jlnstrk.transit.client.hci.method.structgraph.HciStructGraphServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrchannelconfirm.HciSubscrChannelConfirmServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrchannelcreate.HciSubscrChannelCreateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrchanneldelete.HciSubscrChannelDeleteServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrchannelsenddetails.HciSubscrChannelSendDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrchannelupdate.HciSubscrChannelUpdateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrcreate.HciSubscrCreateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrdelete.HciSubscrDeleteServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrdetails.HciSubscrDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrnotification.HciSubscrNotificationServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrsearch.HciSubscrSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrstatus.HciSubscrStatusServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrupdate.HciSubscrUpdateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrusercreate.HciSubscrUserCreateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscruserdelete.HciSubscrUserDeleteServiceRequest
import de.jlnstrk.transit.client.hci.method.subscruserdetails.HciSubscrUserDetailsServiceRequest
import de.jlnstrk.transit.client.hci.method.subscruserupdate.HciSubscrUserUpdateServiceRequest
import de.jlnstrk.transit.client.hci.method.subscrvalidate.HciSubscrValidateServiceRequest
import de.jlnstrk.transit.client.hci.method.tariffsearch.HciTariffSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.tripsearch.HciTripSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.userlogin.HciUserLoginServiceRequest
import de.jlnstrk.transit.client.hci.method.usersearch.HciUserSearchServiceRequest
import de.jlnstrk.transit.client.hci.method.userstore.HciUserStoreServiceRequest
import de.jlnstrk.transit.client.hci.model.HciServiceMethod
import de.jlnstrk.transit.client.hci.model.HciServiceRequest
import kotlin.IllegalArgumentException

public val HciServiceRequest.method: HciServiceMethod
  get() = when (this::class) {
    HciBookingAssortmentServiceRequest::class -> HciServiceMethod.BOOKING_ASSORTMENT
    HciBookingDataServiceRequest::class -> HciServiceMethod.BOOKING_DATA
    HciBookingValidationServiceRequest::class -> HciServiceMethod.BOOKING_VALIDATION
    HciChatMessageSearchServiceRequest::class -> HciServiceMethod.CHAT_MESSAGE_SEARCH
    HciChatMessageStoreServiceRequest::class -> HciServiceMethod.CHAT_MESSAGE_STORE
    HciCheckInJourneySearchServiceRequest::class -> HciServiceMethod.CHECK_IN_JOURNEY_SEARCH
    HciCheckInJourneyStoreServiceRequest::class -> HciServiceMethod.CHECK_IN_JOURNEY_STORE
    HciCheckInLocationSearchServiceRequest::class -> HciServiceMethod.CHECK_IN_LOCATION_SEARCH
    HciCheckInLocationStoreServiceRequest::class -> HciServiceMethod.CHECK_IN_LOCATION_STORE
    HciCheckInTripSearchServiceRequest::class -> HciServiceMethod.CHECK_IN_TRIP_SEARCH
    HciCheckInTripStoreServiceRequest::class -> HciServiceMethod.CHECK_IN_TRIP_STORE
    HciEventLocGeoPosServiceRequest::class -> HciServiceMethod.EVENT_LOC_GEO_POS
    HciFeedbackMailServiceRequest::class -> HciServiceMethod.FEEDBACK_MAIL
    HciFeedbackSearchServiceRequest::class -> HciServiceMethod.FEEDBACK_SEARCH
    HciFeedbackStoreServiceRequest::class -> HciServiceMethod.FEEDBACK_STORE
    HciGeoFeatureDetailsServiceRequest::class -> HciServiceMethod.GEO_FEATURE_DETAILS
    HciGeoFeatureGeoPosServiceRequest::class -> HciServiceMethod.GEO_FEATURE_GEO_POS
    HciGisRouteServiceRequest::class -> HciServiceMethod.GIS_ROUTE
    HciGisSearchServiceRequest::class -> HciServiceMethod.GIS_SEARCH
    HciGraphGeoPosServiceRequest::class -> HciServiceMethod.GRAPH_GEO_POS
    HciHimAffectServiceRequest::class -> HciServiceMethod.HIM_AFFECT
    HciHimDetailsServiceRequest::class -> HciServiceMethod.HIM_DETAILS
    HciHimGeoPosServiceRequest::class -> HciServiceMethod.HIM_GEO_POS
    HciHimMatchServiceRequest::class -> HciServiceMethod.HIM_MATCH
    HciHimSearchServiceRequest::class -> HciServiceMethod.HIM_SEARCH
    HciJourneyCourseServiceRequest::class -> HciServiceMethod.JOURNEY_COURSE
    HciJourneyDetailsServiceRequest::class -> HciServiceMethod.JOURNEY_DETAILS
    HciJourneyGeoPosServiceRequest::class -> HciServiceMethod.JOURNEY_GEO_POS
    HciJourneyGraphServiceRequest::class -> HciServiceMethod.JOURNEY_GRAPH
    HciJourneyMatchServiceRequest::class -> HciServiceMethod.JOURNEY_MATCH
    HciJourneyStructGraphPosServiceRequest::class -> HciServiceMethod.JOURNEY_STRUCT_GRAPH_POS
    HciJourneyTrackMatchServiceRequest::class -> HciServiceMethod.JOURNEY_TRACK_MATCH
    HciJourneyTreeServiceRequest::class -> HciServiceMethod.JOURNEY_TREE
    HciLineDetailsServiceRequest::class -> HciServiceMethod.LINE_DETAILS
    HciLineGeoPosServiceRequest::class -> HciServiceMethod.LINE_GEO_POS
    HciLineMatchServiceRequest::class -> HciServiceMethod.LINE_MATCH
    HciLineSearchServiceRequest::class -> HciServiceMethod.LINE_SEARCH
    HciLocDetailsServiceRequest::class -> HciServiceMethod.LOC_DETAILS
    HciLocGeoPosServiceRequest::class -> HciServiceMethod.LOC_GEO_POS
    HciLocGeoReachServiceRequest::class -> HciServiceMethod.LOC_GEO_REACH
    HciLocGraphServiceRequest::class -> HciServiceMethod.LOC_GRAPH
    HciLocMatchServiceRequest::class -> HciServiceMethod.LOC_MATCH
    HciLocSearchServiceRequest::class -> HciServiceMethod.LOC_SEARCH
    HciLocWalkDetailsServiceRequest::class -> HciServiceMethod.LOC_WALK_DETAILS
    HciLocWalkSearchServiceRequest::class -> HciServiceMethod.LOC_WALK_SEARCH
    HciMatchMeServiceRequest::class -> HciServiceMethod.MATCH_ME
    HciNotificationSearchServiceRequest::class -> HciServiceMethod.NOTIFICATION_SEARCH
    HciNotificationStoreServiceRequest::class -> HciServiceMethod.NOTIFICATION_STORE
    HciOneFieldSearchServiceRequest::class -> HciServiceMethod.ONE_FIELD_SEARCH
    HciPartialSearchServiceRequest::class -> HciServiceMethod.PARTIAL_SEARCH
    HciRatingSearchServiceRequest::class -> HciServiceMethod.RATING_SEARCH
    HciRatingStoreServiceRequest::class -> HciServiceMethod.RATING_STORE
    HciReconstructionServiceRequest::class -> HciServiceMethod.RECONSTRUCTION
    HciReconstructionContextConverterServiceRequest::class ->
        HciServiceMethod.RECONSTRUCTION_CONTEXT_CONVERTER
    HciSearchOnTripServiceRequest::class -> HciServiceMethod.SEARCH_ON_TRIP
    HciServerInfoServiceRequest::class -> HciServiceMethod.SERVER_INFO
    HciShareLocationServiceRequest::class -> HciServiceMethod.SHARE_LOCATION
    HciShareTripServiceRequest::class -> HciServiceMethod.SHARE_TRIP
    HciStationBoardServiceRequest::class -> HciServiceMethod.STATION_BOARD
    HciStructGraphServiceRequest::class -> HciServiceMethod.STRUCT_GRAPH
    HciSubscrChannelConfirmServiceRequest::class -> HciServiceMethod.SUBSCR_CHANNEL_CONFIRM
    HciSubscrChannelCreateServiceRequest::class -> HciServiceMethod.SUBSCR_CHANNEL_CREATE
    HciSubscrChannelDeleteServiceRequest::class -> HciServiceMethod.SUBSCR_CHANNEL_DELETE
    HciSubscrChannelSendDetailsServiceRequest::class -> HciServiceMethod.SUBSCR_CHANNEL_SEND_DETAILS
    HciSubscrChannelUpdateServiceRequest::class -> HciServiceMethod.SUBSCR_CHANNEL_UPDATE
    HciSubscrCreateServiceRequest::class -> HciServiceMethod.SUBSCR_CREATE
    HciSubscrDeleteServiceRequest::class -> HciServiceMethod.SUBSCR_DELETE
    HciSubscrDetailsServiceRequest::class -> HciServiceMethod.SUBSCR_DETAILS
    HciSubscrNotificationServiceRequest::class -> HciServiceMethod.SUBSCR_NOTIFICATION
    HciSubscrSearchServiceRequest::class -> HciServiceMethod.SUBSCR_SEARCH
    HciSubscrStatusServiceRequest::class -> HciServiceMethod.SUBSCR_STATUS
    HciSubscrUpdateServiceRequest::class -> HciServiceMethod.SUBSCR_UPDATE
    HciSubscrUserCreateServiceRequest::class -> HciServiceMethod.SUBSCR_USER_CREATE
    HciSubscrUserDeleteServiceRequest::class -> HciServiceMethod.SUBSCR_USER_DELETE
    HciSubscrUserDetailsServiceRequest::class -> HciServiceMethod.SUBSCR_USER_DETAILS
    HciSubscrUserUpdateServiceRequest::class -> HciServiceMethod.SUBSCR_USER_UPDATE
    HciSubscrValidateServiceRequest::class -> HciServiceMethod.SUBSCR_VALIDATE
    HciTariffSearchServiceRequest::class -> HciServiceMethod.TARIFF_SEARCH
    HciTripSearchServiceRequest::class -> HciServiceMethod.TRIP_SEARCH
    HciUserLoginServiceRequest::class -> HciServiceMethod.USER_LOGIN
    HciUserSearchServiceRequest::class -> HciServiceMethod.USER_SEARCH
    HciUserStoreServiceRequest::class -> HciServiceMethod.USER_STORE
    else -> throw IllegalArgumentException()
  }
