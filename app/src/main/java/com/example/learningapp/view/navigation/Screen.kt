package com.example.learningapp.view.navigation

import com.example.learningapp.view.navigation.NavRoutes.ACCOUNT
import com.example.learningapp.view.navigation.NavRoutes.ACCOUNT_SCREEN1
import com.example.learningapp.view.navigation.NavRoutes.HOME
import com.example.learningapp.view.navigation.NavRoutes.LEADER_BOARD
import com.example.learningapp.view.navigation.NavRoutes.LEARNING
import com.example.learningapp.view.navigation.NavRoutes.PATH_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.QUEST_AND_BADGES

sealed class Screen(val route: String) {
    object Home : Screen(HOME)

    object LeaderBoard:Screen(LEADER_BOARD)
    object Account : Screen(ACCOUNT)

    object  QuestAndBadges :Screen(QUEST_AND_BADGES)
    object Learning : Screen(LEARNING)

    object PathScreen :Screen(PATH_SCREEN)
    object AccountScreen :Screen(ACCOUNT_SCREEN1)
}
