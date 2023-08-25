package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.theme.Green100

@Composable
fun HowManyWordsToLearn(navController: NavController){
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val ( animation, hintText, btnContinue) = createRefs()
        val guidelineTop = createGuidelineFromTop(0.2f)
        val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(150.dp)
                .constrainAs(animation) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guidelineTop)
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.FillBounds,
            iterations = Int.MAX_VALUE
        )

        Text(
            text = "That's 25 words in your first week!",
            modifier = Modifier
                .size(50.dp)
                .padding(20.dp)
                .constrainAs(hintText) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guidelineTop)
                    end.linkTo(parent.end)
                    start.linkTo(animation.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Green100),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(btnContinue) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text(
                text = stringResource(id = R.string.btn_continue),
                color = Color.White
            )
        }
    }
}