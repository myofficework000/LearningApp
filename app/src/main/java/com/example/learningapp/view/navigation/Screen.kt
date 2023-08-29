package com.example.learningapp.view.navigation

import com.example.learningapp.view.navigation.NavRoutes.ACCOUNT
import com.example.learningapp.view.navigation.NavRoutes.HOME
import com.example.learningapp.view.navigation.NavRoutes.LEADER_BOARD
import com.example.learningapp.view.navigation.NavRoutes.LEARNING

sealed class Screen(val route: String) {
    object Home : Screen(HOME)

    object LeaderBoard:Screen(LEADER_BOARD)
    object Account : Screen(ACCOUNT)
    object Learning : Screen(LEARNING)
}
