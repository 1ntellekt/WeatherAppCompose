package com.example.weatherappcompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.data.WeatherModel
import com.example.weatherappcompose.ui.theme.BlueLight

@Composable
fun ListItem(weatherModel: WeatherModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        backgroundColor = BlueLight,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 8.dp, top = 5.dp, bottom = 5.dp)
            ) {
                Text(text = weatherModel.time)
                Text(text = weatherModel.condition, color = Color.White)
            }
            Text(
                text = weatherModel.currentTemp.ifEmpty {
                    "${weatherModel.maxTemp}/${weatherModel.minTemp}"
                },
                style = TextStyle(fontSize = 19.sp, color = Color.White)
            )
            AsyncImage(
                model = "http:${weatherModel.icon}",
                contentDescription = "imgListItem1",
                modifier = Modifier.size(35.dp).padding(end = 8.dp)
            )
        }
    }
}