package com.test.android.temperaturetest.domain.repository

import android.content.Context
import com.google.gson.Gson
import com.test.android.temperaturetest.R
import com.test.android.temperaturetest.domain.model.TemperatureModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TemperatureRepositoryImpl @Inject constructor(
    private val context: Context
) : TemperatureRepository {
    override fun fetchTemperatures(): Flow<TemperatureModel> {
        val objectArrayString: String = context.resources.openRawResource(R.raw.temperatures).bufferedReader().use { it.readText() }
        val objectArray = Gson().fromJson(objectArrayString, TemperatureModel::class.java)
        return flow {
            delay(2000)
            emit(objectArray)
        }.flowOn(Dispatchers.IO)
    }
}