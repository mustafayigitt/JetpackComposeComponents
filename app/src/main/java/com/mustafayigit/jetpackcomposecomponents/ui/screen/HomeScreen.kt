package com.mustafayigit.jetpackcomposecomponents.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mustafayigit.jetpackcomposecomponents.NavScreen
import com.mustafayigit.jetpackcomposecomponents.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    homeViewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = homeViewModel.getTitle())

        Button(
            onClick = { navController.navigate(NavScreen.Explore.route) },
        ) {
            Text(text = "Go to Explore screen")
        }
    }
}

