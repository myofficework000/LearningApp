package com.example.learningapp.view.screen.post_login_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.BlueCard
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.GreyButtonText
import com.example.learningapp.view.theme.White

@Preview(showBackground = true)
@Composable
fun FeedScreen() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val (fieldCard1, fieldCard2, fieldCard3, fieldCard4, fieldCard5, fieldCard6, fieldCard7) =
            createRefs()

        // Card 1

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard1) {
                    top.linkTo(parent.top)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = BlueCard)
        ) {
            Column(Modifier.padding(10.dp)) {
                Row {
                    Text(text = stringResource(R.string.celebrate_achievements_with_friends),
                        color = White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp))

                }
                Button(
                    onClick = {},
                    colors= ButtonDefaults.buttonColors(White),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.add_friends),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = BlueCard,
                        fontWeight = FontWeight.Bold)
                }
            }
        }

        // Card 2

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard2) {
                    top.linkTo(fieldCard1.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.streak_pic),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = "1 day",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = stringResource(R.string.a_lesson_every_day),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )

                Button(
                    onClick = {},
                    colors= ButtonDefaults.buttonColors(White),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(0.5f)
                        .border(2.dp, GreyButtonText, shape = ButtonDefaults.outlinedShape)
                ) {
                    Text(text = stringResource(R.string.start_a_lesson),
                        fontSize = 16.sp,
                        color = BlueCard,
                        fontWeight = FontWeight.Bold)
                }
            }
        }

        // 3rd card

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard3) {
                    top.linkTo(fieldCard2.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.tunein_music),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = "3 days",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(R.string.tune_into_learning))
                    }
                    withStyle(style = SpanStyle(color = BlueCard, fontWeight = FontWeight.Bold)){
                        append(stringResource(R.string.here_are_4_tips))
                    }
                },
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        // card 4

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard4) {
                    top.linkTo(fieldCard3.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.baby_pic),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = stringResource(R.string._6_days),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(R.string.these_are))
                    }
                    withStyle(style = SpanStyle(color = BlueCard, fontWeight = FontWeight.Bold)){
                        append(stringResource(R.string._8_common_mistakes))
                    }
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(R.string.to_watch_out_for_during_your_lessons))
                    }
                },
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        // card 5

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard5) {
                    top.linkTo(fieldCard4.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.sleeping_pic),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = stringResource(R.string._12_days),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(R.string.what_wil_english_sound_like_in_100_years))
                    }
                    withStyle(style = SpanStyle(color = BlueCard, fontWeight = FontWeight.Bold)){
                        append(stringResource(R.string.here_are_our_predictions))
                    }
                },
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        // card 6

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard6) {
                    top.linkTo(fieldCard5.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.woman_thinking_pic),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = stringResource(R.string._26_days),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(R.string.our_brains_are_built))
                    }
                    withStyle(style = SpanStyle(color = BlueCard, fontWeight = FontWeight.Bold)){
                        append(stringResource(R.string.it_s_all_about_tracking_patterns))
                    }
                },
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        // card 7

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(10.dp)
                .constrainAs(fieldCard7) {
                    top.linkTo(fieldCard6.bottom)
                }
                .clickable { },
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.people_happy_pic),
                    contentDescription = stringResource(R.string.streak),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )

                Text(text = stringResource(R.string._742_days),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                    color = GreyButtonText
                )

                Text(text = stringResource(R.string.welcome_to_your_feed),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}