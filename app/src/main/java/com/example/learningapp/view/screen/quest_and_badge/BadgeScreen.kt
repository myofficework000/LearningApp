package com.example.learningapp.view.screen.quest_and_badge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R

@Preview(showBackground = true)
@Composable
fun DemoBadgeScreen() {
    BadgeScreen()
}

@Composable
fun BadgeScreen() {
    val rawComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.animation_badge)
    )

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val guideline = createGuidelineFromTop(0.2f)
        val (imageView, txtTitle, txtSubtitle) = createRefs()

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(220.dp)
                .constrainAs(imageView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(guideline)
                }, contentScale = ContentScale.Inside,
            iterations = 1
        )
        Text(text = stringResource(id = R.string.earn_your_first_badge),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(txtTitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageView.bottom)
                })

        Text(text = stringResource(id = R.string.complete_each_month),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(txtSubtitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(txtTitle.bottom)
                })
    }
}