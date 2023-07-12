package com.example.godonut.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.godonut.GoNutRoutes
import com.example.godonut.ui.theme.GoDonutTheme

@Composable
fun DetailsScreen(navController: NavHostController) {
    DetailsContent(){
        navController.navigate(GoNutRoutes.HomeScreen.route)
    }
}

@Composable
fun DetailsContent(navController: () -> Unit) {

}


@Preview(showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    GoDonutTheme {
        val navController = rememberNavController()
        DetailsScreen(navController)
    }
}