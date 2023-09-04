package com.example.learningapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.view.navigation.NavRoutes.CHAT_UI
import com.example.learningapp.view.navigation.NavRoutes.DAY_STREAK_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.FRESH_START_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.FUN_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.GET_APP_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.GET_STARTED_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.HEAR_AND_CHOOSE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.HEAR_FROM_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.HOW_DO_YOU_SAY_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.INTRO_ACHIEVEMENT_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.INTRO_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.KNOWLEDGE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.LANGUAGE_LIST
import com.example.learningapp.view.navigation.NavRoutes.LEARNING_REASON_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.LETS_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.MOTIVATION_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.PROFILE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.SELECT_STREAK_GOAL_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.SIGN_IN_EMAIL_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.SIGN_IN_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.STREAK_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.TIME_CHOICE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.TRANSLATE_SENTENCE_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.TRANSLATE_SENTENCE_ZULU_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.UNLOCKED_GIFT_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.WHAT_IS_STREAK_SCREEN
import com.example.learningapp.view.screen.AchievementScreen
import com.example.learningapp.view.screen.ChatScreen
import com.example.learningapp.view.screen.DayStreakScreen
import com.example.learningapp.view.screen.FreshStartScreen
import com.example.learningapp.view.screen.FunScreen
import com.example.learningapp.view.screen.GetAppScreen
import com.example.learningapp.view.screen.GetStartedScreen
import com.example.learningapp.view.screen.HearAndChooseWordScreen
import com.example.learningapp.view.screen.HearFromScreen
import com.example.learningapp.view.screen.HowDoYouSay
import com.example.learningapp.view.screen.IntroScreen
import com.example.learningapp.view.screen.KnowledgeScreen
import com.example.learningapp.view.screen.LanguagesList
import com.example.learningapp.view.screen.LearningReason
import com.example.learningapp.view.screen.LetsScreen
import com.example.learningapp.view.screen.MotivationScreen
import com.example.learningapp.view.screen.ProfileScreen
import com.example.learningapp.view.screen.SelectStreak
import com.example.learningapp.view.screen.SignInEmailScreen
import com.example.learningapp.view.screen.SignInScreen
import com.example.learningapp.view.screen.StreakScreen
import com.example.learningapp.view.screen.TimesList
import com.example.learningapp.view.screen.TranslateSentence
import com.example.learningapp.view.screen.TranslateSentenceBrother
import com.example.learningapp.view.screen.UnlockedGiftScreen
import com.example.learningapp.view.screen.WhatIsStreakScreen
import com.example.learningapp.viewmodel.SignInSignUpViewModel

@Composable
fun MyApp(signInSignUpViewModel: SignInSignUpViewModel) {
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
        composable(route = MOTIVATION_SCREEN) { MotivationScreen(navController) }
        composable(route = FUN_SCREEN) { FunScreen(navController) }
        composable(route = HOW_DO_YOU_SAY_SCREEN) { HowDoYouSay(navController) }
        composable(route = HEAR_AND_CHOOSE_SCREEN) { HearAndChooseWordScreen(navController) }
        composable(route = SIGN_IN_EMAIL_SCREEN) { SignInEmailScreen(
            navController=navController,
            signInSignUpViewModel=signInSignUpViewModel) }
        composable(route = STREAK_SCREEN) { StreakScreen(navController) }
        composable(route = TRANSLATE_SENTENCE_SCREEN) { TranslateSentenceBrother(navController) }
        composable(route = LETS_SCREEN) { LetsScreen(navController) }
        composable(route = UNLOCKED_GIFT_SCREEN) { UnlockedGiftScreen(navController) }

        composable(route = GET_APP_SCREEN) { GetAppScreen(navController)}
        composable(route = TRANSLATE_SENTENCE_ZULU_SCREEN) { TranslateSentence(navController) }
        composable(route = SELECT_STREAK_GOAL_SCREEN) { SelectStreak(navController)}
        composable(route = CHAT_UI) {ChatScreen(navController)}
        composable(route = GET_APP_SCREEN) { GetAppScreen(navController) }
        composable(route = PROFILE_SCREEN) {ProfileScreen(navController)}
        composable(route = DAY_STREAK_SCREEN) {DayStreakScreen(navController=navController)}
        composable(route = WHAT_IS_STREAK_SCREEN) {WhatIsStreakScreen(navController=navController)}

    }
}