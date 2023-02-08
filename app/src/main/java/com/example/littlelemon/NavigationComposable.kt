package com.example.littlelemon

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun MyNavigation(navController: NavHostController, sharedPreferences: SharedPreferences, database: AppDatabase) {
    val storedData = sharedPreferences.getString("email", null) != null
    var startDestination = Onboarding.route
    // Checking to see if registered
    if (storedData) {
        startDestination = Home.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination) {
        composable(Home.route) {
            Home(navController, database)
        }
        composable(Onboarding.route) {
            Onboarding(navController, sharedPreferences)
        }
        composable(Profile.route) {
            Profile(navController, sharedPreferences)
        }
    }
}