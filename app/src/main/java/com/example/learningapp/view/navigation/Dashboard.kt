package com.example.learningapp.view.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningapp.view.screen.post_login_screens.Account
import com.example.learningapp.view.screen.post_login_screens.Home
import com.example.learningapp.view.screen.post_login_screens.LeaderBoardDummy
import com.example.learningapp.view.screen.post_login_screens.Learning

@ExperimentalMaterial3Api
@Composable
fun Dashboard(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) { Home(navController) }
        composable(route = Screen.LeaderBoard.route) { LeaderBoardDummy(navController) }
        composable(route = Screen.Account.route) { Account(navController) }
        composable(route = Screen.Learning.route) { Learning(navController) }
    }
}