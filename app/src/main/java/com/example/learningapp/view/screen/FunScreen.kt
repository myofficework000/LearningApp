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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.theme.Green40

@Composable
fun FunScreen(navController: NavController) {
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
                Text(
                    text = stringResource(id = (R.string.so_duolingo_fun_like_a_game)),
                    modifier = Modifier
                        .align(CenterHorizontally)
                )

                LottieAnimation(
                    composition = rawComposition,
                    iterations = Int.MAX_VALUE,
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .align(CenterHorizontally)
                )
            }

        }

        Button(
            onClick = { /* Goes to PAVANI's SCREEN (correct image) */ },
            colors= ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(fieldButton) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}