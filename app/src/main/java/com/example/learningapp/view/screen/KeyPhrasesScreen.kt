package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.view.theme.BlueCard
import com.example.learningapp.view.theme.LighterGrey
import com.example.learningapp.view.theme.White

@Composable
fun KeyPhrasesScreen() {
    ConstraintLayout(Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(10.dp)) {

        val (fieldKey, fieldGreet, fieldCard1, fieldCard2,
            fieldCard3, fieldCard4, fieldCard5, fieldCard6) = createRefs()

        Text(text = stringResource(R.string.key_phrases_ss),
            Modifier
                .constrainAs(fieldKey) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(20.dp, top = 15.dp),
            color = BlueCard,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(text = stringResource(R.string.greet_people),
            Modifier
                .constrainAs(fieldGreet) {
                    top.linkTo(fieldKey.bottom)
                    start.linkTo(parent.start)
                }
                .padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Card(
            Modifier
                .padding(start = 40.dp, 10.dp)
                .constrainAs(fieldCard1) {
                    top.linkTo(fieldGreet.bottom)
                    start.linkTo(parent.start)
                }, colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.holla_buenos_dias),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.hello_good_morning),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }

        Card(
            Modifier
                .padding(10.dp, end = 40.dp, top = 85.dp, bottom = 15.dp)
                .constrainAs(fieldCard2) {
                    top.linkTo(fieldCard1.top)
                    end.linkTo(parent.end)
                }, colors = CardDefaults.cardColors(containerColor = LighterGrey),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.buenos_dias),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.good_morning),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }

        Card(
            Modifier
                .padding(start = 40.dp, 10.dp)
                .constrainAs(fieldCard3) {
                    top.linkTo(fieldCard2.bottom)
                    start.linkTo(parent.start)
                }, colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.adios_buenas_noches),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.bye_good_night),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }

        Card(
            Modifier
                .padding(10.dp, end = 40.dp, top = 85.dp, bottom = 15.dp)
                .constrainAs(fieldCard4) {
                    top.linkTo(fieldCard3.top)
                    end.linkTo(parent.end)
                }, colors = CardDefaults.cardColors(containerColor = LighterGrey),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.buenas_noches),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.good_night),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }

        Card(
            Modifier
                .padding(start = 40.dp, 10.dp)
                .constrainAs(fieldCard5) {
                    top.linkTo(fieldCard4.bottom)
                    start.linkTo(parent.start)
                }, colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.hola_yo_soy_juan),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.hello_i_am_juan),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }

        Card(
            Modifier
                .padding(10.dp, end = 40.dp, top = 85.dp)
                .constrainAs(fieldCard6) {
                    top.linkTo(fieldCard5.top)
                    end.linkTo(parent.end)
                }, colors = CardDefaults.cardColors(containerColor = LighterGrey),
            elevation = CardDefaults.cardElevation(3.dp)){

            ConstraintLayout(Modifier.padding(10.dp)) {
                val (fieldImage, fieldSpanish, fieldEnglish) = createRefs()

                Image(
                    painter = painterResource(R.drawable.baseline_volume_up_35),
                    contentDescription = stringResource(R.string.volume_up),
                    modifier = Modifier
                        .constrainAs(fieldImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(top = 8.dp)
                )

                Text(text = stringResource(R.string.mucho_gusto),
                    modifier = Modifier
                        .constrainAs(fieldSpanish) {
                            top.linkTo(parent.top)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp, top = 10.dp),
                    fontSize = 16.sp
                )

                Text(text = stringResource(R.string.nice_to_meet_you),
                    modifier = Modifier
                        .constrainAs(fieldEnglish) {
                            top.linkTo(fieldSpanish.bottom)
                            start.linkTo(fieldImage.end)
                        }
                        .padding(5.dp), fontSize = 16.sp
                )
            }
        }
    }
}