package com.example.weatherappcompose.domain.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

    @Composable
    fun ItemRow(item: ItemRowModel){
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .background(Color.White),
        ) {
            Image(
                painter = painterResource(id = item.imgId),
                contentDescription = "img-${item.imgId}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(3.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            ) {
                Text(text = item.title)
                Text(
                    text = item.content,
                    maxLines = if(isExpanded) 10 else 1,
                    modifier = Modifier.clickable {
                        isExpanded = !isExpanded
                    }
                )
            }
        }
    }

