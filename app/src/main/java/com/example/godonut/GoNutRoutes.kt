package com.example.godonut

sealed class GoNutRoutes(val route:String){

    object OnBoardingScreen:GoNutRoutes("On_Boarding")
    object HomeScreen:GoNutRoutes("Home")
    object DetailsScreen:GoNutRoutes("Details")

}
