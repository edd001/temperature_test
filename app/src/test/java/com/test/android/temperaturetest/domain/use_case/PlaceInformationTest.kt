package com.test.android.temperaturetest.domain.use_case

import com.test.android.temperaturetest.domain.model.PlaceData
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

internal class PlaceInformationTest {
    private lateinit var placeInformation: PlaceInformation
    private lateinit var placeData: PlaceData

    @Before
    fun setUp() {
        placeData = PlaceData("City1",25,"C")
        placeInformation = PlaceInformation()
    }

    @Test
    fun `Place value properly set`(){
        val placeValue = placeInformation(placeData).first
        val expectedValue = placeData.value.toString()
        assertThat(placeValue).isEqualTo(expectedValue)
    }

    @Test
    fun `Place name properly set`(){
        val placeName = placeInformation(placeData).second
        val expectedName = placeData.place
        assertThat(placeName).isEqualTo(expectedName)
    }

    @Test
    fun `Place unit properly set`(){
        val placeUnit = placeInformation(placeData).third
        val expectedUnit = placeData.unit
        assertThat(placeUnit).isEqualTo(expectedUnit)
    }
}