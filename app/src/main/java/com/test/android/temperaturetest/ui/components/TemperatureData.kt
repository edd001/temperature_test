package com.test.android.temperaturetest.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.android.temperaturetest.ui.theme.LocalSpacing

@Composable
fun TemperatureData(
    label: String,
    temperature: String,
    textSize: TextUnit,
    modifier: Modifier = Modifier
){
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h1,
            fontSize = textSize,
            color = Color.Black,
            modifier = modifier.weight(1f)
        )
        OutlinedTextField(
            value = temperature,
            onValueChange = { },
            textStyle = TextStyle.Default.copy(fontSize = textSize),
            modifier = modifier.weight(3f).padding(horizontal = 20.dp),
            shape =  RoundedCornerShape(0.dp),
            readOnly = true,
            singleLine = true
        )
    }
}

@Preview
@Composable
fun PreviewTemperatureData() {
    TemperatureData(label = "Temperature", temperature = "25C", textSize = 16.sp)
}