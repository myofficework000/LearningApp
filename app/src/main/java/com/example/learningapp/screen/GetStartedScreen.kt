package com.example.learningapp.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.ui.theme.Green100

@Preview
@Composable
fun GetStartedScreen() {
    val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (textHello, animationView, nextButton, backButton) = createRefs()
        Text(text = stringResource(id = R.string.intro_text_ready),
            modifier = Modifier.constrainAs(textHello) {
                bottom.linkTo(animationView.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(200.dp)
                .constrainAs(animationView) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.FillBounds,
            iterations = 5
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Green100),
            modifier = Modifier.constrainAs(nextButton) {
                top.linkTo(animationView.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(
                text = "Continue",
                color = Color.White
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.constrainAs(backButton) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }) {
            Text(
                text = "<-",
                color = Color.Gray
            )
        }
    }
}