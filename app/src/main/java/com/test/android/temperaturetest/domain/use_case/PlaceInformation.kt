package com.test.android.temperaturetest.domain.use_case

import com.test.android.temperaturetest.domain.model.PlaceData

class PlaceInformation {
    operator fun invoke(data: PlaceData?): Triple<String, String, String> {
        val safePlaceValue = data?.value.toString()
        val safePlaceName = data?.place ?: ""
        val safePlaceUnit = data?.unit ?: ""
        return Triple (
            safePlaceValue,
            safePlaceName,
            safePlaceUnit
        )
    }
}