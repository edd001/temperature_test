package com.test.android.temperaturetest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.android.temperaturetest.domain.use_case.PlaceInformation
import com.test.android.temperaturetest.ui.components.TemperatureCard
import com.test.android.temperaturetest.ui.viewmodel.TemperatureViewModel

@Composable
fun TemperatureScreen(
    viewModel: TemperatureViewModel = hiltViewModel()
) {
    val placeData by viewModel.placeData.observeAsState()

    Column(Modifier.fillMaxHeight()) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(color = MaterialTheme.colors.background)
        )
        key(placeData) {
            val data = PlaceInformation().invoke(placeData)
            TemperatureCard(
                buttonRandomClick = { viewModel.getNextLocation() },
                temperature = data.first,
                unit = data.third,
                city = data.second,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(color = MaterialTheme.colors.background)
        )
    }
}