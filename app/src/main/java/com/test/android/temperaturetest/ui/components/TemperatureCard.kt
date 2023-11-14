package com.test.android.temperaturetest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.android.temperaturetest.R
import com.test.android.temperaturetest.ui.theme.LocalSpacing
import com.test.android.temperaturetest.ui.theme.vibrantBlue

@Composable
fun TemperatureCard(
    buttonRandomClick: () -> Unit,
    temperature: String,
    unit: String,
    city: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = modifier.padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemperatureData(
                label = stringResource(id = R.string.location),
                temperature = city,
                textSize = 16.sp
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.background)
            )
            TemperatureData(
                label = stringResource(id = R.string.temperature),
                temperature = stringResource(id = R.string.temperature_unit, temperature, unit),
                textSize = 16.sp
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.background)
            )
            Button(
                onClick = buttonRandomClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = vibrantBlue)
            ) {
                Text(
                    text = stringResource(id = R.string.button_main_screen),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTemperatureCard() {
    TemperatureCard(temperature = "25", unit = "C", city = "Tai Po", buttonRandomClick = {})
}