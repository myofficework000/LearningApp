package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Achievement
import com.example.learningapp.modal.dto.HearFromData
import com.example.learningapp.modal.dto.StartLevel
import com.example.learningapp.modal.dto.getAchievements
import com.example.learningapp.view.screen.utils.ContinueButton
import com.example.learningapp.view.screen.utils.OwlAnimationWithTextOnLeft
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.White

@Preview
@Composable
fun StartLevelScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (containerOwl, listOfAchievements, btnContinue) = createRefs()
        OwlAnimationWithTextOnLeft(
            text = stringResource(R.string.choose_start_level),
            modifier = Modifier.constrainAs(containerOwl) {
                top.linkTo(parent.top)
            })

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(listOfAchievements) {
                    top.linkTo(containerOwl.bottom)
                    bottom.linkTo(btnContinue.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            items(getStartingLevel()) { startLevel ->
                StartLevelViewHolder(startLevel)
            }
        }
        ContinueButton(onclick = { }, modifier = Modifier
            .constrainAs(btnContinue) {
                bottom.linkTo(parent.bottom)
            } )
    }
}

@Composable
fun StartLevelViewHolder(startLevel: StartLevel) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(15.dp)
                .background(White)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val (iconImage, titleText, subtitleText) = createRefs()
            Image(
                painter = painterResource(id = startLevel.img),
                contentDescription = "Level Img",
                modifier = Modifier
                    .constrainAs(iconImage) {
                        top.linkTo(parent.top, 10.dp)
                        start.linkTo(parent.start, 10.dp)
                    }
                    .size(50.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = startLevel.title,
                modifier = Modifier.constrainAs(titleText) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(iconImage.end, margin = 16.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                fontSize = 20.sp,
                color = Color.Black,
            )
            Text(
                text = startLevel.subTitle,
                modifier = Modifier.constrainAs(subtitleText) {
                    top.linkTo(titleText.bottom, margin = 10.dp)
                    start.linkTo(iconImage.end, margin = 16.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                fontSize = 16.sp,
                color = Color.Gray,
            )
        }
    }
}

fun getStartingLevel() = listOf(
    StartLevel("Learning {language} for the first time?",
        "Start from scratch", R.drawable.newbie),
    StartLevel("Already know some {language}?",
        "Answer some question to find your level", R.drawable.advanced)

)