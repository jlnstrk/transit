package de.jlnstrk.transit.sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            println("Content!")
            DepartureList(viewModel)
        }
    }
}

@Composable
fun DepartureList(viewModel: SampleViewModel) {
    val state = viewModel.nearbyDepartures.collectAsState(initial = SampleViewModel.DataState.Loading).value
    println("after state")
    when (state) {
        SampleViewModel.DataState.Loading -> {
            CircularProgressIndicator()
        }
        is SampleViewModel.DataState.Error -> {
            Text("Error!")
        }
        SampleViewModel.DataState.NoResult -> {
            Text("?")
        }
        is SampleViewModel.DataState.Data -> {
            Column(modifier = Modifier.verticalScroll(state = ScrollState(0))) {
                state.data.journeys.forEach { journey ->
                    Text("${journey.line.label} -> ${journey.directionTo?.name}")
                }
            }
        }
    }
    println("after whatever")
}