package com.example.dessertclicker.ui.theme

import androidx.annotation.DrawableRes
import com.example.dessertclicker.R

data class UiState (
    val dessertSort: Int = 0,
    val totalRevenue: Int = 0,
    @DrawableRes val image: Int = R.drawable.cupcake
)