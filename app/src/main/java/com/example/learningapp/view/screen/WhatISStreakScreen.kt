package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.view.theme.ColorBlue
import com.example.learningapp.view.theme.Orange


@Composable
fun WhatIsStreakScreen(count:Int = 5,navController: NavController){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (textNumber, dayStreakText, cardView, btnUp, btnStreak, buttonContinue) = createRefs()
        val guidLine = createGuidelineFromTop(0.2f)

        Text(text = "$count",
            color = Orange,
            fontSize = 80.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(textNumber) {
                top.linkTo(guidLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }.padding(10.dp))

        Text(text = "day streak!",
            color = Orange,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(dayStreakText) {
                top.linkTo(textNumber.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })

        CardView(Modifier.constrainAs(cardView) {
            top.linkTo(dayStreakText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, count, stringResource(R.string.streak_Count))


        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                ColorBlue
            ),
            modifier = Modifier.fillMaxWidth()
                .constrainAs(buttonContinue) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, 10.dp)
                }
                .padding(start = 4.dp)
        ) {
            Text(
                text = stringResource(R.string.btn_continue), color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

    }
}
