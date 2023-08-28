package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes.CHAT_UI
import com.example.learningapp.view.navigation.NavRoutes.SIGN_IN_EMAIL_SCREEN
import com.example.learningapp.view.navigation.NavRoutes.SIGN_IN_SCREEN
import com.example.learningapp.view.screen.utils.sendBigPictureStyleNotifications
import com.example.learningapp.view.screen.utils.sendInboxStyleNotifications
import com.example.learningapp.view.theme.Green40

@Composable
fun IntroScreen(navController: NavController) {
    val context = LocalContext.current

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val guideline = createGuidelineFromTop(0.2f)
        val (imageView, imageTitle, textDesc, buttonStarted, buttonOutline) = createRefs()
        val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(220.dp)
                .constrainAs(imageView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(guideline)
                }, contentScale = ContentScale.Inside,
            iterations = 500
        )
        Text(text = stringResource(id = R.string.intro_title),
            textAlign = TextAlign.Center,
            color = Green40,
            fontSize = 38.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(imageTitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageView.bottom)
                })

        Text(text = stringResource(id = R.string.intro_text),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(textDesc) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageTitle.bottom)
                })

        Button(onClick = {
            navController.navigate(SIGN_IN_EMAIL_SCREEN)
        },
            colors = ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonStarted) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonOutline.top)
                }
                .padding(horizontal = 16.dp)) {
            Text(
                stringResource(id = R.string.get_started),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        OutlinedButton(onClick = {
            navController.navigate(CHAT_UI)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .constrainAs(buttonOutline) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(
                stringResource(id = R.string.i_have_already_account),
                color = Green40,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }
    }
}