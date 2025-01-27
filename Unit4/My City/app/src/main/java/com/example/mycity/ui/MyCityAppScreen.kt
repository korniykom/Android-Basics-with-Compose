package com.example.mycity.ui

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(stringResource(currentScreen.title))
        },
        modifier = modifier
    )
}

enum class MyCityScreen(@StringRes val title: Int) {
    Category1(title = R.string.Category1),
    Category2(title = R.string.Category2),
    Category3(title = R.string.Category3)

}

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentScreen: MyCityScreen = MyCityScreen.values().find {
        it.name == backStackEntry?.value?.destination?.route} ?: MyCityScreen.Category1


    Scaffold(
        topBar = {
            MyCityAppBar(currentScreen = currentScreen)
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Category1.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.Category1.name) {
               Category1()
            }
            composable(route = MyCityScreen.Category2.name) {
                Text(text = "Category2")
            }
            composable(route = MyCityScreen.Category3.name) {
                Text(text = "Category3")
            }
        }
    }
}