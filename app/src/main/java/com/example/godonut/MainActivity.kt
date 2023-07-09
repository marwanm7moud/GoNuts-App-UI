package com.example.godonut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.godonut.screens.DetailsScreen
import com.example.godonut.screens.HomeScreen
import com.example.godonut.screens.OnBoardingScreen
import com.example.godonut.ui.theme.GoDonutTheme
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
                    NavHost(navController = navController, startDestination = GoNutRoutes.OnBoardingScreen.route) {
                        composable(GoNutRoutes.OnBoardingScreen.route) { OnBoardingScreen() }
                        composable(GoNutRoutes.HomeScreen.route) { HomeScreen() }
                        composable(GoNutRoutes.DetailsScreen.route) { DetailsScreen() }
                    }
                }
            }
        }
    }
}