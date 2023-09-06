package com.example.learningapp.view.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningapp.view.screen.AccountScreen
import com.example.learningapp.view.screen.PathScreen
import com.example.learningapp.view.screen.ProfileScreen
import com.example.learningapp.view.screen.choose_section.ChooseSectionScreen
import com.example.learningapp.view.screen.post_login_screens.LeaderBoardDummy
import com.example.learningapp.view.screen.post_login_screens.Learning
import com.example.learningapp.view.screen.quest_and_badge.QuestAndBadgeScreen

@ExperimentalMaterial3Api
@Composable
fun Dashboard(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) { ChooseSectionScreen(navController) }
        composable(route = Screen.LeaderBoard.route) { LeaderBoardDummy(navController) }
        composable(route = Screen.Account.route) { ProfileScreen(navController) }
        composable(route = Screen.QuestAndBadges.route) { QuestAndBadgeScreen(navController) }
        composable(route = Screen.Learning.route) { Learning(navController) }
        composable(route = Screen.PathScreen.route) { PathScreen() }
        composable(route = NavRoutes.ACCOUNT_SCREEN1) { AccountScreen(navController=navController, context) }
    }
}