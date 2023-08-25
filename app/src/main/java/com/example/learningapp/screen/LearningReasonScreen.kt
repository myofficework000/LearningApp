package com.example.learningapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.screen.dto.LearningReason
import com.example.learningapp.ui.theme.Green100


@Composable
@Preview
fun LearningReason() {
    val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val (ListOfReasons, Animation, AskText, BtnContinue) = createRefs()
        val guidelineTop = createGuidelineFromTop(0.25f)

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(200.dp)
                .constrainAs(Animation) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guidelineTop)
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.FillBounds,
            iterations = 5
        )

        Text(
            text = "Why are you learning Spanish?",
            modifier = Modifier
                .size(50.dp)
                .constrainAs(AskText) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guidelineTop)
                    end.linkTo(parent.end)
                    start.linkTo(Animation.end)
                    width = Dimension.fillToConstraints
                }
        )

        LazyColumn(
            modifier = Modifier
                .constrainAs(ListOfReasons) {
                    top.linkTo(guidelineTop)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(BtnContinue.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            items(getReasons()) { learningReason ->
                Column {
                    ReasonItem(reason = LearningReason(learningReason.reason, learningReason.image))
                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Green100),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(BtnContinue) {
                    top.linkTo(ListOfReasons.bottom)
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

@Composable
fun ReasonItem(reason: LearningReason) {
    val selectedOption = remember { mutableStateOf("unselected") }
    Card {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (ReasonImage, ReasonDescription, ReasonRadioButton) = createRefs()
            Image(
                painter = painterResource(id = reason.image),
                contentDescription = reason.reason,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .constrainAs(ReasonImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )
            RadioButton(
                selected = selectedOption.value == "selected",
                onClick = {
                    if (selectedOption.value == "selected") {
                        selectedOption.value = "unselected"
                    } else {
                        selectedOption.value = "selected"
                    }
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Green100,
                    unselectedColor = androidx.compose.ui.graphics.Color.Gray
                ),
                modifier = Modifier.constrainAs(ReasonRadioButton) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
            )
            Text(reason.reason,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(ReasonDescription) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(ReasonImage.end)
                    })
        }
    }
}

private fun getReasons(): List<LearningReason> =
    listOf(
        LearningReason("Just for fun", R.drawable.blog),
        LearningReason("Boost my Career", R.drawable.blog),
        LearningReason("Support my education", R.drawable.blog),
        LearningReason("Spend time productively", R.drawable.blog),
        LearningReason("prepare for travel", R.drawable.blog),
        LearningReason("Connect with people", R.drawable.blog),
        LearningReason("other", R.drawable.blog)
    )