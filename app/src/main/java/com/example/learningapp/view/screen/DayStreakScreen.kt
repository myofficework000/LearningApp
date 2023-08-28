package com.example.learningapp.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.view.theme.ColorBlue
import com.example.learningapp.view.theme.LightGrey
import com.example.learningapp.view.theme.Orange
import com.example.learningapp.view.theme.SelectedWord


@Composable
fun DayStreakScreen(count:Int = 1,navController: NavController){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (textNumber, dayStreakText, cardView, btnUp, btnStreak, textContinue) = createRefs()
        val guidLine = createGuidelineFromTop(0.2f)

        Text(text = "$count",
            color = Orange,
            fontSize = 80.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(textNumber) {
                top.linkTo(guidLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })

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
        }, count)

        OutlinedButton(
            onClick = { },
            border = BorderStroke(2.dp, LightGrey.copy(alpha = 0.5f)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.wrapContentWidth().constrainAs(btnUp) {
                start.linkTo(parent.start, 10.dp)
                bottom.linkTo(textContinue.top, 10.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Image(
                painter = painterResource(R.drawable.up), contentDescription = "image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                ColorBlue
            ),
            modifier = Modifier
                .constrainAs(btnStreak) {
                    end.linkTo(parent.end, 10.dp)
                    start.linkTo(btnUp.end)
                    bottom.linkTo(textContinue.top, 10.dp)
                    width = Dimension.fillToConstraints
                }
                .padding(start = 4.dp)
        ) {
            Text(
                text = stringResource(R.string.what_is_streak), color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Text(text = "Continue",
            color = ColorBlue,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(textContinue) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, 10.dp)
            })

    }


}



@SuppressLint("SuspiciousIndentation")
@Composable
fun CardView(modifier: Modifier, count:Int = 5, text: String = stringResource(R.string.streak_message)){
    val days = listOf<String>("Su","Mo","Tu","We","Th","Fr","Sa")

        Card(modifier =
        modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp),
        border = BorderStroke(1.dp, Color.Gray),
            colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
                    days.forEachIndexed { index, s ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = s,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = if (index + 1 == count) Orange else Color.LightGray
                            )
                            Image(
                                imageVector = Icons.Rounded.CheckCircle, contentDescription = null,
                                modifier = Modifier.size(35.dp),
                                colorFilter = ColorFilter.tint(if (index + 1 <= count) Orange else Color.LightGray)
                            )
                        }

                    }
                }
                Divider(thickness = 2.dp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth())

                Text(text = text ,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top =20.dp, start = 10.dp, end = 10.dp, bottom = 10.dp))
        }

    }

}