package com.example.godonut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.godonut.screens.DetailsScreen
import com.example.godonut.screens.HomeScreen
import com.example.godonut.screens.onBoarding.OnBoardingScreen
import com.example.godonut.ui.theme.GoDonutTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoDonutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val systemUiController = rememberSystemUiController()
                    NavHost(
                        navController = navController,
                        startDestination = GoNutRoutes.DetailsScreen.route
                    ) {
                        composable(GoNutRoutes.OnBoardingScreen.route) {
                            OnBoardingScreen(
                                navController,
                                systemUiController
                            )
                        }
                        composable(GoNutRoutes.HomeScreen.route) { HomeScreen(navController) }
                        composable(GoNutRoutes.DetailsScreen.route) { DetailsScreen(navController) }
                    }

                }
            }
        }
    }
}