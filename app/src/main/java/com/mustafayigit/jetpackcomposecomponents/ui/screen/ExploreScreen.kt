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
import com.mustafayigit.jetpackcomposecomponents.viewmodel.ExploreViewModel

@Composable
fun ExploreScreen(
    navController: NavController = rememberNavController(),
    exploreViewModel: ExploreViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = exploreViewModel.getTitle())

        Button(
            onClick = { navController.navigateUp() },
        ) {
            Text(text = "back to previous screen")
        }
    }
}

