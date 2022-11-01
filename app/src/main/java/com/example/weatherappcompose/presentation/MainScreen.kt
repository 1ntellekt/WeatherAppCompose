package com.example.weatherappcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.data.WeatherModel
import com.example.weatherappcompose.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = BlueLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "20 Jun 2022 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "http://cdn.weatherapi.com/weather/64x64/day/302.png",
                        contentDescription = "img2",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 3.dp, end = 8.dp)
                    )
                }
                Text(
                    text = "Prague",
                    style = TextStyle(fontSize = 25.sp),
                    color = Color.White
                )
                Text(
                    text = "30°C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "imgIconButton1",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "22°C/12°C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cloud_sync),
                            contentDescription = "imgIconButton1",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(){
    val tabs = listOf("Hours","Days")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(start = 5.dp, end = 5.dp)
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { position->
                 TabRowDefaults.Indicator(
                     Modifier.pagerTabIndicatorOffset(pagerState,position)
                 )
            },
            backgroundColor = BlueLight,
            contentColor = Color.White
        ) {
            tabs.forEachIndexed { index, str ->
                Tab(
                    selected = false,
                    onClick = {
                       coroutineScope.launch {
                           pagerState.animateScrollToPage(index)
                       }
                    },
                    text = {
                        Text(text = str)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index->
            LazyColumn(modifier = Modifier.fillMaxSize()){
                itemsIndexed(
                    listOf(
                        WeatherModel(
                            "London",
                            "10:00",
                            "25ºC",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/day/176.png",
                            "",
                            "",
                            ""
                        ),
                        WeatherModel(
                            "London",
                            "26/07/2022",
                            "",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/day/176.png",
                            "26º",
                            "12º",
                            "xdfghxdfthxfghxdft"
                        )
                    )
                ) { _, item->
                    ListItem(weatherModel = item)
                }
            }
        }
    }
}