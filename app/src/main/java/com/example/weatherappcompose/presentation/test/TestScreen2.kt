package com.example.weatherappcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherappcompose.R

@Preview(showBackground = true)
@Composable
fun TestScreen2(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        GetListItem()
        GetListItem()
        GetListItem()
        GetListItem()
        GetListItem()
    }
}

    @Composable
    fun GetListItem(){
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp)
        ){
            Box() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = "imgIcon",
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        modifier = Modifier.padding(start = 15.dp)
                    ) {
                        Text(text = "Name")
                        Text(text = "Description")
                    }
                }
            }
        }
    }

