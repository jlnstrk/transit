package de.jlnstrk.transit.sample.android

import androidx.lifecycle.ViewModel
import de.jlnstrk.transit.common.extensions.require
import de.jlnstrk.transit.common.model.Coordinates
import de.jlnstrk.transit.common.model.Location
import de.jlnstrk.transit.common.response.StationBoardData
import de.jlnstrk.transit.common.response.base.ServiceResult
import de.jlnstrk.transit.common.service.StationBoardService
import de.jlnstrk.transit.sample.SampleProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

val REFERENCE_COORDINATES = Coordinates(latitude = 52.521992, longitude = 13.413244)

class SampleViewModel : ViewModel() {
    private val provider = SampleProvider

    sealed interface DataState<out D> {
        object Loading : DataState<Nothing>
        object NoResult : DataState<Nothing>
        data class Error(val throwable: Throwable?) : DataState<Nothing>
        data class Data<T>(val data: T) : DataState<T>
    }

    val nearbyDepartures: Flow<DataState<StationBoardData>> = flow {
        val result = provider.require<StationBoardService>()
            .stationBoard(
                mode = StationBoardService.Mode.DEPARTURES,
                location = Location.Point(coordinates = REFERENCE_COORDINATES),
            )
        when (result) {
            is ServiceResult.Success -> emit(DataState.Data(result.result))
            is ServiceResult.Failure -> emit(DataState.Error(result.exception))
            ServiceResult.NoResult -> emit(DataState.NoResult)
        }
    }
}