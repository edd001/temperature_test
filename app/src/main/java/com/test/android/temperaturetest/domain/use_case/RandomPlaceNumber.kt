package com.test.android.temperaturetest.domain.use_case

import com.test.android.temperaturetest.domain.model.PlaceData
import java.util.*

class RandomPlaceNumber {
    operator fun invoke (places: List<PlaceData>): Int {
        val size = places.size - 1
        return Random().nextInt(size)
    }
}