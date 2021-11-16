package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.response.*
import de.jlnstrk.transit.util.response.base.ServiceResult

public typealias JourneyDetailsResult = ServiceResult<JourneyDetailsData,
        JourneyDetailsService.Error>

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

public typealias StatusInformationResult = ServiceResult<StatusInformationData,
        StatusInformationService.Error>

public typealias NetworkMapsResult = ServiceResult<NetworkMapsData,
        NetworkMapsService.Error>

public typealias NetworkGeometryResult = ServiceResult<NetworkGeometryData,
        NetworkGeometryService.Error>