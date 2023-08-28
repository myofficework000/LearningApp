package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes.LETS_SCREEN
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.TextGray

@Composable
fun StreakScreen(navController: NavController) {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (fieldBox, fieldButton) = createRefs()

        val rawComposition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.animation_owl)
        )

        Box(
            Modifier
                .constrainAs(fieldBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .wrapContentSize()) {

            Column {

                LottieAnimation(
                    composition = rawComposition,
                    iterations = Int.MAX_VALUE,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .align(CenterHorizontally)
                )

                Text(
                    text = stringResource(R.string.keep_your_streak_alive),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(10.dp),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = stringResource(R.string.best_way_to_learn),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(10.dp),
                    fontSize = 20.sp,
                    color = TextGray
                )
            }

        }

        Button(
            onClick = {navController.navigate(LETS_SCREEN)},
            colors= ButtonDefaults.buttonColors(Blue100),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(fieldButton) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.i_m_ready),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}