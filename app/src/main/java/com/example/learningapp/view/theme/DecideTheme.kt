package com.example.learningapp.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun decideTheme(theme: DynamicThemes?) = theme ?: (
        if (isSystemInDarkTheme()) DynamicThemes.DEFAULT_DARK
        else DynamicThemes.DEFAULT_LIGHT
        )