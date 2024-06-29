package com.example.rickyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickyapp.HomeViewModel
import com.example.rickyapp.ui.screens.DetailScreen
import com.example.rickyapp.ui.screens.HomeScreen

@Composable
fun HomeNavigation(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeNav.HOME_SCREEN) {
        composable(HomeNav.HOME_SCREEN) {
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }

        composable(HomeNav.DETAIL_SCREEN) {
            DetailScreen(navController = navController, homeViewModel = homeViewModel)
        }
    }
}