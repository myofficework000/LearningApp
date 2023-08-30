package com.example.learningapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.StreakGoal
import com.example.learningapp.view.screen.utils.OwlAnimation
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.Orange100

@Composable
fun SelectStreak(navController: NavController){
    val streaks = listOf(
        StreakGoal(stringResource(R.string.day_7_streak), stringResource(R.string.good), stringResource(R.string.complete1x)),
        StreakGoal(stringResource(R.string.day_14_streak), stringResource(R.string.great), stringResource(R.string.complete5x)),
        StreakGoal(stringResource(R.string.day_30_streak), stringResource(R.string.incredible), stringResource(R.string.complete25x)),
        StreakGoal(stringResource(R.string.day_50_streak), stringResource(R.string.unstoppable), stringResource(R.string.complete125x)),
    )
    var selectedStreak by remember { mutableStateOf<StreakGoal?>(null)}

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (titleText, streakColumn, animationOwl, commentText, commitButton) = createRefs()
        Text(
            modifier = Modifier
                .constrainAs(titleText){
                    top.linkTo(parent.top, 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.commit_to_learn))
        Column(
            modifier = Modifier
                .constrainAs(streakColumn) {
                    top.linkTo(titleText.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            streaks.forEach {streak ->
                SingleStreak(
                    streak = streak,
                    isSelected = streak == selectedStreak,
                    onClick = {selectedStreak = streak}
                )
            }
        }
        OwlAnimation(Modifier.constrainAs(animationOwl){
            top.linkTo(streakColumn.bottom, 30.dp)
            start.linkTo(parent.start)
        })
        Text(
            modifier = Modifier
                .constrainAs(commentText){
                    top.linkTo(animationOwl.top)
                    bottom.linkTo(animationOwl.bottom)
                    start.linkTo(animationOwl.end)
                    end.linkTo(parent.end, 10.dp)
                    width = Dimension.fillToConstraints
                },
            color = Color.Gray,
            text = selectedStreak?.speed ?: stringResource(R.string.what_is_streak_goal))

        Button(
            modifier = Modifier
                .constrainAs(commitButton) {
                    bottom.linkTo(parent.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedStreak == null) Color.LightGray else Blue100,
                contentColor = if (selectedStreak == null) Color.Gray else Color.White
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = if (selectedStreak == null) stringResource(R.string.select_streak) else stringResource(R.string.commit_goal)
            )
        }
    }
}

@Composable
fun SingleStreak(streak: StreakGoal, isSelected: Boolean, onClick: ()->Unit){
    Box(
        modifier = Modifier
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = if (isSelected) Orange100 else Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .padding(10.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = if (isSelected) Orange100 else Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = streak.streak)
            Text(
                color = if (isSelected) Orange100 else Color.Gray,
                fontSize = 18.sp,
                text = streak.level)
        }
        if (isSelected){
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)
                    .offset(12.dp, -12.dp),
                tint = Orange100
            )
        }
    }
}