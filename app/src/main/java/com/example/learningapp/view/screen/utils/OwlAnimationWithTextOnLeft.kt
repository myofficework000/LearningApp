package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R


@Composable
fun OwlAnimationWithTextOnLeft(modifier: Modifier, text:String){
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        val (animationOwl, txtHearing) = createRefs()
        OwlAnimation(Modifier.constrainAs(animationOwl){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Text(text = text,
            modifier = Modifier.constrainAs(txtHearing){
                start.linkTo(animationOwl.end)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
    }
}

@Composable
fun OwlAnimation(modifier: Modifier) {
    val rawComposition
            by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

    LottieAnimation(
        composition = rawComposition,
        contentScale = ContentScale.Fit,
        iterations = Int.MAX_VALUE,
        modifier = modifier
            .width(width = 200.dp)
            .height(height = 200.dp)
    )
}