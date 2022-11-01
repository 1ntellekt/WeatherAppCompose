package com.example.weatherappcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherappcompose.R
import com.example.weatherappcompose.domain.test.ItemRow
import com.example.weatherappcompose.domain.test.ItemRowModel

@Preview(showBackground = true)
@Composable
fun TestScreen5(){
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
    ){
        itemsIndexed(
            listOf(
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-1","description-col1 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-2","description-col2 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-3","description-col3 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-4","description-col4 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-5","description-col5 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-6","description-col6 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv"),
                ItemRowModel(R.drawable.ic_baseline_person_24,"col-7","description-col7 wkflrferklferjflerfjerklfjerklfrjerklfjerkflerj jdfvkdfvndfkvgdfnvkdfnvdfkvndfjkvndfkvdfnvkdfnvkdfvnkdfvndfv")
            )
        ){ index, item ->
            ItemRow(item = item)
        }
    }
}