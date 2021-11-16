# api-hci

### Kotlin multiplatform bindings for HCI (Hafas Client Interface)

Requires Ktor clients for each applied target.

#### Supported Methods

* Him*X*
  * HimDetails
  * HimGeoPos
  * HimSearch
* Journey*X*
  * JourneyCourse
  * JourneyDetails
  * JourneyGeoPos
  * JourneyMatch
* Line*X*
  * LineDetails
  * LineGeoPos
  * LineMatch
  * LineSearch
* Loc*X*
  * LocDetails
  * LocGeoPos
  * LocGeoReach
  * LocGraph
  * LocMatch
  * LocSearch
  * LocWalkDetails
  * LocWalkSearch
* Reconstruction
* ServerInfo
* StationBoard
* TripSearch

#### Unsupported methods

* Geo*X*
  * GeoFeatureDetails
  * GeoFeatureGeoPos
* GisRoute
* GraphGeoPos
* Him*X*
  * HimAffect
  * HimMatch
* Journey*X*
  * JourneyGraph
  * JourneyStructGraphPos
  * JourneyTrackMatch
* OneFieldSearch
* PartialSearch
* SearchOnTrip
* StructGraph
* Subscr*X*
* TariffSearch