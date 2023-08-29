package com.example.learningapp.view.screen.post_login_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun Account(navController: NavController) {
    Box(Modifier.fillMaxSize().background(Color.Yellow)) {
        Text(text = "Account")
    }
}