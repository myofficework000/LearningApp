package com.example.learningapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.theme.GetApp_Background
import com.example.learningapp.view.theme.GetApp_Btn_Text


/////testing
@Preview(showBackground = true)
@Composable
fun PreviewGetAppScreen() {
    GetAppScreen(rememberNavController())
}
/////////

// Use GetAppScreen() as main
@Composable
fun GetAppScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier
        .background(GetApp_Background)
        .fillMaxSize()) {

        val guideline = createGuidelineFromTop(0.1f)
        val (imageView, txtTitle, txtSubtitle, buttonGetApp, buttonNoThanks) = createRefs()
        val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_getapp))

        Text(text = stringResource(R.string.getapp_title),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp)
                .width(220.dp)
                .constrainAs(txtTitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(guideline)
                })
        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(220.dp)
                .constrainAs(imageView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(txtTitle.bottom)
                }, contentScale = ContentScale.Inside,
            iterations = Int.MAX_VALUE
        )


        Text(text = stringResource(R.string.getapp_subtitle),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(txtSubtitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageView.bottom)
                })

        Button(onClick = {
        },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .constrainAs(buttonGetApp) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonNoThanks.top)
                }
               ) {
            Text(
                text = stringResource(R.string.btn_get_app_for_free_CAPS),
                color = GetApp_Btn_Text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }

        OutlinedButton(onClick = {  },
            border = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .constrainAs(buttonNoThanks) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(
                text = stringResource(R.string.btn_no_thanks_CAPS),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,

            )
        }
    }
}