package com.test.android.temperaturetest.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.android.temperaturetest.domain.model.PlaceData
import com.test.android.temperaturetest.domain.model.TemperatureModel
import com.test.android.temperaturetest.domain.repository.TemperatureRepository
import com.test.android.temperaturetest.domain.use_case.RandomPlaceNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TemperatureViewModel @Inject constructor(
    private val repository: TemperatureRepository
): ViewModel() {
    private val _temperatureData = MutableLiveData<TemperatureModel>()
    val temperatureData: LiveData<TemperatureModel>
        get() = _temperatureData
    private val _placeData = MutableLiveData<PlaceData>()
    val placeData: LiveData<PlaceData>
        get() = _placeData
    private val randomPlaceNumber = RandomPlaceNumber()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            repository.fetchTemperatures().collect {
                _temperatureData.value = it
                getNextLocation()
                Log.d("TemperatureViewModel", it.toString())
            }
        }
    }

    fun getNextLocation() {
        temperatureData.value?.temperature?.data?.let {
            _placeData.value =
                temperatureData.value?.temperature?.data?.get(randomPlaceNumber(it))
        }
    }
}