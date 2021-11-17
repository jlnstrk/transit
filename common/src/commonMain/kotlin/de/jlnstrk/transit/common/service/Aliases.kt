package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.response.*
import de.jlnstrk.transit.common.response.base.ServiceResult

public typealias JourneyDetailsResult = ServiceResult<JourneyDetailsData,
        JourneyDetailsService.Error>

public typealias JourneyPositionsResult = ServiceResult<JourneyListData,
        JourneyPositionsService.Error>

public typealias TripSearchResult = ServiceResult<TripSearchData,
        TripSearchService.Error>

public typealias TripRefreshResult = ServiceResult<TripRefreshData,
        TripRefreshService.Error>

public typealias LocationSearchResult = ServiceResult<LocationListData,
        LocationSearchService.Error>

public typealias NearbyLocationsResult = ServiceResult<LocationListData,
        NearbyLocationsService.Error>

public typealias StationBoardResult = ServiceResult<StationBoardData,
        StationBoardService.Error>

public typealias StatusInformationResult = ServiceResult<MessageListData,
        StatusInformationService.Error>

public typealias NetworkMapsResult = ServiceResult<NetworkMapsData,
        NetworkMapsService.Error>

public typealias NetworkGeometryResult = ServiceResult<NetworkGeometryData,
        NetworkGeometryService.Error>