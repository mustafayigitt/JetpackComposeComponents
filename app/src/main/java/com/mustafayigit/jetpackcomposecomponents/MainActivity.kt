package com.mustafayigit.jetpackcomposecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mustafayigit.jetpackcomposecomponents.ui.screen.ExploreScreen
import com.mustafayigit.jetpackcomposecomponents.ui.screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreen.getStartDestination()
    ) {
        composable(NavScreen.Home.route) { HomeScreen(navController) }
        composable(NavScreen.Explore.route) { ExploreScreen(navController) }
    }

}


sealed class NavScreen(val route: String) {
    object Home : NavScreen("home")
    object Explore : NavScreen("explore")

    companion object {
        fun getStartDestination() = Home.route
    }
}