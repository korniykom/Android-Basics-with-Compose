/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import android.provider.ContactsContract.Data
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen

enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    EntreeMenu(title = R.string.choose_entree),
    SideDishMenu(title = R.string.choose_side_dish),
    AccompanimentMenu(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    currentScreen: LunchTrayScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(
                        text = stringResource(id = currentScreen.title),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
            )
                },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStateEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStateEntry?.destination?.route?: LunchTrayScreen.Start.name
    )
    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = LunchTrayScreen.Start.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = { navController.navigate(LunchTrayScreen.EntreeMenu.name)},
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = LunchTrayScreen.EntreeMenu.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = { cancelAndNavigateToStart(viewModel, navController)},
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.SideDishMenu.name)},
                    onSelectionChanged = { viewModel.updateEntree(it)},
                    modifier = Modifier.fillMaxSize(),
                )
            }

            composable(route = LunchTrayScreen.SideDishMenu.name){
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = { cancelAndNavigateToStart(viewModel, navController)},
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.AccompanimentMenu.name)},
                    onSelectionChanged = { viewModel.updateSideDish(it)},
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = LunchTrayScreen.AccompanimentMenu.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {cancelAndNavigateToStart(viewModel, navController)},
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Checkout.name)},
                    onSelectionChanged = { viewModel.updateAccompaniment(it)},
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = LunchTrayScreen.Checkout.name){
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.Start.name)},
                    onCancelButtonClicked = { navController.navigate(LunchTrayScreen.Start.name)},
                    modifier = Modifier
                )
            }
        }
    }
}

private fun cancelAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
}