package com.test.android.temperaturetest.domain.use_case

import com.test.android.temperaturetest.domain.model.PlaceData
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class RandomPlaceNumberTest {
    private lateinit var randomPlaceNumber: RandomPlaceNumber
    private lateinit var list: List<PlaceData>
    private var numberOfElements: Int = 0

    @Before
    fun setUp() {
        list = listOf(
            PlaceData("City1",25,"C"),
            PlaceData("City2",26,"C"),
            PlaceData("City3",27,"C")
        )
        numberOfElements = list.size - 1
        randomPlaceNumber = RandomPlaceNumber()
    }

    @Test
    fun `Random Index for list properly calculated`() {
        val randomIndex = randomPlaceNumber(list)
        assertTrue(randomIndex in 0..numberOfElements)
    }
}