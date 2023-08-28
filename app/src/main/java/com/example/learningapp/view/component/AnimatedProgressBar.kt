package com.example.learningapp.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.grey

@Composable
fun AnimatedProgressBar(progress: Int) {
    val maxProgress = 100f
    val color = Green40
    val trackColor = grey // Track color

    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f) // Width of 70% of the screen
            .height(10.dp) // Height of 10 dp
            .padding(vertical = 16.dp)
            .background(trackColor)
    ) {
        LinearProgressIndicator(
            progress = progress / maxProgress,
            modifier = Modifier
                .fillMaxHeight()
                .background(color)
        )
    }
}