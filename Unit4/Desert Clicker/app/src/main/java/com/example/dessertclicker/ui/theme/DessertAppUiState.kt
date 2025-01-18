package com.example.dessertclicker.ui.theme

import com.example.dessertclicker.data.Datasource

data class DessertAppUiState(
    val dessertsSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[0].price,
    val currentDessertImageId: Int = Datasource.dessertList[0].imageId
)