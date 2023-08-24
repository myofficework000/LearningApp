package com.example.learningapp.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R

@Composable
fun BuildIntroScreen() {
    val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.main_logo))
    val progress by animateLottieCompositionAsState(composition = rawComposition)

    LottieAnimation(
        composition = rawComposition,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        iterations = 5
    )
}