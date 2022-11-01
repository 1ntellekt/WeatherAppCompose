package com.example.weatherappcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request.Method
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherappcompose.data.WeatherModel
import com.example.weatherappcompose.presentation.MainCard
import com.example.weatherappcompose.presentation.TabLayout
import com.example.weatherappcompose.ui.theme.WeatherAppComposeTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {

                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }

                val currentDay = remember {
                    mutableStateOf(
                        WeatherModel("","","",
                            "","","","",""
                        )
                    )
                }

                getData("Prague", this, daysList,currentDay)

                Image(
                    painter = painterResource(id = R.drawable.weather_bg),
                    contentDescription = "img1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.8f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard(currentDay)
                    TabLayout(daysList)
                }

            }
        }
    }

    private fun getData(city:String, context:Context,
                        daysListState: MutableState<List<WeatherModel>>,
                        currentDay:MutableState<WeatherModel>
    ){
        val API_KEY = "7a16d23417a140f981b144426222310"
        val url = "http://api.weatherapi.com/v1/forecast.json?" +
                "key=$API_KEY" +
                "&q=$city" +
                "&days=3" +
                "&aqi=no&alerts=no\n"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Method.GET, url,{ response->
                val list = getWeatherByDays(response)
                daysListState.value = list
                currentDay.value = list.first()
                Log.d("response", "Volley response: $response")
            }, { error->
                Log.e("error", error.message.toString())
            }
        )
        queue.add(stringRequest)
    }

    private fun getWeatherByDays(response:String):List<WeatherModel>{
        if (response.isEmpty()) return listOf()
        val mainObject = JSONObject(response)
        val city = mainObject.getJSONObject("location").getString("name")
        val list = mutableListOf<WeatherModel>()
        val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
        for (i in 0 until days.length()){
            val item = days[i] as JSONObject
            list.add(
                WeatherModel(
                    city = city,
                    time = item.getString("date"),
                    currentTemp = "",
                    icon = item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                    condition = item.getJSONObject("day").getJSONObject("condition").getString("text"),
                    maxTemp = item.getJSONObject("day").getString("maxtemp_c"),
                    minTemp = item.getJSONObject("day").getString("mintemp_c"),
                    hours = item.getJSONArray("hour").toString()
                )
            )
        }
        list[0] = list[0].copy(
            time = mainObject.getJSONObject("current").getString("last_updated"),
            currentTemp = mainObject.getJSONObject("current").getString("temp_c")
        )
        return list
    }

}