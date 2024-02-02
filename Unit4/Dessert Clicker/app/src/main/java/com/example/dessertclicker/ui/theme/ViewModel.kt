package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val UiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onDessertClick() {
        _uiState.update {cakeScreenUiState ->
            val dessertSold: Int = cakeScreenUiState.dessertSort + 1
            val revenue: Int = cakeScreenUiState.totalRevenue + 10

            cakeScreenUiState.copy(
                totalRevenue = revenue,
                dessertSort = dessertSold,
                image = R.drawable.donut
            )
        }
    }
}