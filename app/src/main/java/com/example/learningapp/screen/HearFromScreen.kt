package com.example.learningapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.screen.dto.HearFromData
import com.example.learningapp.ui.theme.Green40

@Preview
@Composable
fun HearFromScreen(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()) {
        val (containerOwl, listOfHearing, btnContinue) = createRefs()
        ContainerOwlAnimationWithText(
            text = stringResource(R.string.hearing_from),
            modifier = Modifier.constrainAs(containerOwl){
            top.linkTo(parent.top)
        })
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(listOfHearing) {
                    top.linkTo(containerOwl.bottom)
                    bottom.linkTo(btnContinue.top)
                    height = Dimension.fillToConstraints
                }
        ){
            items(getHearing()){ hearFrom ->
                HearFromViewHolder(hearFrom)
            }
        }
        Button(
            onClick = {        },
            colors= ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(btnContinue) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue))
        }
    }
}

@Composable
fun HearFromViewHolder(hearFrom : HearFromData){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()) {
            val (imgOwl,txtHearingTitle) = createRefs()
            Image(painter = painterResource(id = hearFrom.img),
                contentDescription = "hearFrom Img ",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .constrainAs(imgOwl) { start.linkTo(parent.start) })

            Spacer(modifier = Modifier.size(10.dp))

            Text(text = hearFrom.name,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(txtHearingTitle) {
                        top.linkTo(parent.top)
                        start.linkTo(imgOwl.end)
                        bottom.linkTo(parent.bottom)
                    })
        }
    }

}
fun getHearing()= listOf(
    HearFromData("Facebook",R.drawable.facebook),
    HearFromData("Instagram",R.drawable.instagram),
    HearFromData("Blog",R.drawable.blog),
    HearFromData("Media",R.drawable.media),
    HearFromData("TV",R.drawable.tv),
    HearFromData("App store",R.drawable.google_store),
    HearFromData("Google Search",R.drawable.google_search),
    HearFromData("Youtube",R.drawable.youtube),
    HearFromData("TikTok",R.drawable.tiktok),
)