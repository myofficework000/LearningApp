package com.example.learningapp.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.learningapp.view.navigation.Dashboard
import com.example.learningapp.view.navigation.Screen

@ExperimentalMaterial3Api
@Composable
fun DashBoardUI(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(bottomBar = { BottomAppBarUI(navController) },
            content = { paddingValues ->
                ContentOfApp(
                    paddingValues,
                    navController
                )
            })
    }
}

@ExperimentalMaterial3Api
@Composable
fun ContentOfApp(paddingValues: PaddingValues, navController: NavHostController) {
    Dashboard(navController)
}

@Composable
fun BottomAppBarUI(navController: NavController) {
    val navItemState = remember { mutableStateOf(false) }

    NavigationBar(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        contentColor = Color.Blue,
        containerColor = Color.Green
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            selected = navItemState.value,
            onClick = { navController.navigate(Screen.Home.route) }
        )

        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Leaderboard, contentDescription = null) },
            selected = navItemState.value,
            onClick = { navController.navigate(Screen.LeaderBoard.route) }
        )

        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = null) },
            selected = navItemState.value,
            onClick = { navController.navigate(Screen.Learning.route) }
        )

        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Badge, contentDescription = null) },
            selected = navItemState.value,
            onClick = { navController.navigate(Screen.QuestAndBadges.route) }
        )


        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Face, contentDescription = null) },
            selected = navItemState.value,
            onClick = { navController.navigate(Screen.Account.route) }
        )
    }
}