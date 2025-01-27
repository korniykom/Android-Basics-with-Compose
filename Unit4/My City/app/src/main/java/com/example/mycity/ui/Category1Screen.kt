package com.example.mycity.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.R
import com.example.mycity.ui.components.CityCard

@Composable
fun Category1(

    modifier: Modifier = Modifier
) {
    val cities = listOf("City1", "City2","City1", "City2","City1", "City2","City1", "City2")
    LazyColumn() {
        items(cities) { city ->
            CityCard(image = R.drawable.ic_launcher_background, description = city)
        }

    }
}y