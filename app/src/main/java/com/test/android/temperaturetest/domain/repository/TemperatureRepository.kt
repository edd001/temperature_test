package com.test.android.temperaturetest.domain.repository

import com.test.android.temperaturetest.domain.model.TemperatureModel
import kotlinx.coroutines.flow.Flow

interface TemperatureRepository {
    fun fetchTemperatures(): Flow<TemperatureModel>
}