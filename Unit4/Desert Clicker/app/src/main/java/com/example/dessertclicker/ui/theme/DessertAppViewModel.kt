package com.example.dessertclicker.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.determineDessertToShow
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertAppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DessertAppUiState())
    val uiState: StateFlow<DessertAppUiState> = _uiState.asStateFlow()

    fun dessertClick(): Unit {

        val dessertToShow = determineDessertToShow(Datasource.dessertList, uiState.value.dessertsSold)

        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.currentDessertPrice + currentState.revenue,
                dessertsSold = currentState.dessertsSold.inc(),
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price

            )
        }
    }
}