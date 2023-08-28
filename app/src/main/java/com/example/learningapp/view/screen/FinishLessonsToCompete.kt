package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.Orange100

@Composable
@Preview
fun FinishLessonsToCompete() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (nextButton, profileBox) = createRefs()
        val lessonNum by remember { mutableStateOf("9 lessons") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(profileBox) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.leader_board_preview),
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(300.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append("Finish ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Orange100)) {
                        append(lessonNum)
                    }
                    append(" to start competing Leaderboards")
                },
                Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}