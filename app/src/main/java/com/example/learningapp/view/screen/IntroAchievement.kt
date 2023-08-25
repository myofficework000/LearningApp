package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Achievement
import com.example.learningapp.modal.dto.getAchievements
import com.example.learningapp.view.navigation.NavRoutes.TIME_CHOICE_SCREEN
import com.example.learningapp.view.screen.utils.OwlAnimation
import com.example.learningapp.view.theme.Green40

@Composable
fun AchievementScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (containerOwl, listOfAchievements, btnContinue) = createRefs()
        LogoContainer(modifier = Modifier.constrainAs(containerOwl) {
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
            items(getAchievements()) { achievement ->
                AchievementItem(achievement)
            }
        }

        Button(
            onClick = { navController.navigate(TIME_CHOICE_SCREEN)},
            colors = ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(btnContinue) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue))
        }
    }
}

@Composable
fun LogoContainer(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (animationOwl, txtHearing) = createRefs()
        OwlAnimation(Modifier.constrainAs(animationOwl) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Text(text = stringResource(R.string.intro_achieve),
            modifier = Modifier.constrainAs(txtHearing) {
                start.linkTo(animationOwl.end)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
    }
}

@Composable
fun AchievementItem(achievement: Achievement) {
    ConstraintLayout(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        val (iconImage, titleText, subtitleText) = createRefs()
        Image(
            painter = painterResource(id = achievement.img),
            contentDescription = "Nothing",
            modifier = Modifier
                .constrainAs(iconImage) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
                .size(30.dp)
                .padding(end = 8.dp)
        )

        Text(
            text = achievement.title,
            modifier = Modifier.constrainAs(titleText) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(iconImage.end, margin = 16.dp)
            },
            fontSize = 20.sp,
            color = Color.Black,
        )
        Text(
            text = achievement.subtitle,
            modifier = Modifier.constrainAs(subtitleText) {
                top.linkTo(titleText.bottom, margin = 10.dp)
                start.linkTo(iconImage.end, margin = 16.dp)
            },
            fontSize = 16.sp,
            color = Color.Gray,
        )
    }
}



