package com.example.learningapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.theme.GreyButton
import com.example.learningapp.view.theme.GreyButtonText
import com.example.learningapp.view.theme.White

@Composable
fun TimesList(navController: NavController) {
    val languages = getTimes()
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (fieldLazyColumn, fieldAnimation, fieldButton, fieldText) = createRefs()

        val rawComposition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.animation_owl)
        )

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .constrainAs(fieldAnimation) {
                    top.linkTo(parent.top)
                },
            iterations = Int.MAX_VALUE
        )

        Text(
            text = "What is your daily learning goal?",
            modifier = Modifier.constrainAs(fieldText) {
                top.linkTo(parent.top)
                bottom.linkTo(fieldAnimation.bottom)
                start.linkTo(fieldAnimation.end)
                end.linkTo(parent.end)
            })

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .constrainAs(fieldLazyColumn) {
                    top.linkTo(fieldAnimation.bottom)
                    bottom.linkTo(fieldButton.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }) {
            items(languages) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(10.dp)
                        .clickable { },
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(containerColor = White)
                ) {
                    Row(Modifier.padding(10.dp)) {

                        Text(
                            text = item.duration,
                            modifier = Modifier.weight(1f)
                        )

                        Spacer(Modifier.size(10.dp))

                        Text(
                            text = item.type,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .constrainAs(fieldButton) {
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(GreyButton)
        ) {
            Text(
                text = stringResource(id = R.string.btn_continue),
                color = GreyButtonText
            )
        }
    }
}

data class Times(val duration: String, val type: String)

@Composable
fun getTimes() = listOf(
    Times("3 min / day", "Casual"),
    Times("10 min / day", "Regular"),
    Times("15 min / day", "Serious"),
    Times("30 min / day", "Intense")
)