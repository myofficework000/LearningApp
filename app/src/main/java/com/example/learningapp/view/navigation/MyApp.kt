package com.example.learningapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.view.navigation.NavRoutes.FRESH_START_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.GET_STARTED_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.HEAR_FROM_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.INTRO_ACHIEVEMENT_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.INTRO_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.KNOWLEDGE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.LANGUAGE_LIST
import com.example.learningapp.view.navigation.NavRoutes.LEARNING_REASON_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.SIGN_IN_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.TIME_CHOICE_SCREEN
import com.example.learningapp.view.screen.AchievementScreen
import com.example.learningapp.view.screen.FreshStartScreen
import com.example.learningapp.view.screen.GetStartedScreen
import com.example.learningapp.view.screen.HearFromScreen
import com.example.learningapp.view.screen.IntroScreen
import com.example.learningapp.view.screen.KnowledgeScreen
import com.example.learningapp.view.screen.LanguagesList
import com.example.learningapp.view.screen.LearningReason
import com.example.learningapp.view.screen.SignInScreen
import com.example.learningapp.view.screen.TimesList

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = INTRO_SCREEN
    ) {
        //Add all the destinations
        composable(route = INTRO_SCREEN) { IntroScreen(navController) }
        composable(route = GET_STARTED_SCREEN) { GetStartedScreen(navController) }
        composable(route = LANGUAGE_LIST) { LanguagesList(navController) }
        composable(route = KNOWLEDGE_SCREEN) { KnowledgeScreen(navController) }
        composable(route = TIME_CHOICE_SCREEN) { TimesList(navController) }
        composable(route = HEAR_FROM_SCREEN) { HearFromScreen(navController) }
        composable(route = FRESH_START_SCREEN) { FreshStartScreen(navController) }
        composable(route = INTRO_ACHIEVEMENT_SCREEN) { AchievementScreen(navController) }
        composable(route = LEARNING_REASON_SCREEN) { LearningReason(navController) }
        composable(route = SIGN_IN_SCREEN) { SignInScreen(navController) }
    }
}