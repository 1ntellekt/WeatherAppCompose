package com.example.weatherappcompose.presentation

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

@Composable
fun SetWeather(name:String, context: Context){
    val stateTemp = remember {
        mutableStateOf("Unknown")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Temp in $name = ${stateTemp.value} C")

        }
        Box (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                onClick = {
                    getResult(city = name, state = stateTemp, context = context)
                }
            ) {
                Text(text = "Refresh")
            }
        }
    }
}

private fun getResult(
    city:String,
    state:MutableState<String>,
    context: Context
){
    val API_KEY = "7a16d23417a140f981b144426222310";
    val url = "http://api.weatherapi.com/v1/current.json?" +
            "key=$API_KEY" +
            "&q=$city" +
            "&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
         Request.Method.GET,
         url, { response->
            //state.value = response
            val jsonObj = JSONObject(response)
            val current = jsonObj.getJSONObject("current")
            state.value = current.getString("temp_c")
         }, { error->
            Log.d("error", error.message.toString())
         }
     )
    queue.add(stringRequest)

}