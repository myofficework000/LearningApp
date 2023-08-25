package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Languages
import com.example.learningapp.view.navigation.NavRoutes.HEAR_FROM_SCREEN
import com.example.learningapp.view.theme.GreyButton
import com.example.learningapp.view.theme.GreyButtonText
import com.example.learningapp.view.theme.White

@Composable
fun LanguagesList(navController: NavController) {
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
            text = stringResource(id = R.string.what_you_want_to_learn),
            modifier = Modifier.constrainAs(fieldText) {
                top.linkTo(parent.top)
                bottom.linkTo(fieldAnimation.bottom)
                start.linkTo(fieldAnimation.end)
                end.linkTo(parent.end)
            })

        val languages = getLanguages()
        LazyColumn(
            Modifier
                .wrapContentHeight()
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
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = "Image",
                            Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )

                        Spacer(Modifier.size(10.dp))

                        Text(
                            text = item.name,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                navController.navigate(HEAR_FROM_SCREEN)
            },
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

@Composable
fun getLanguages() = listOf(
    Languages(stringResource(R.string.english_language), R.drawable.united_flag),
    Languages(stringResource(R.string.hindi_language), R.drawable.india_flag),
    Languages(stringResource(R.string.chinese_language), R.drawable.china_flag),
    Languages(stringResource(R.string.german_language), R.drawable.germany_flag),
    Languages(stringResource(R.string.italian_language), R.drawable.italy_flag),
    Languages(stringResource(R.string.spanish_language), R.drawable.spain_flag),
    Languages(stringResource(R.string.french_language), R.drawable.france_flag),
    Languages(stringResource(R.string.arabic_language), R.drawable.saudi_flag)
)