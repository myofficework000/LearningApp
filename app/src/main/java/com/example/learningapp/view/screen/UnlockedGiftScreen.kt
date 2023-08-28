package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.learningapp.view.theme.Btn_EquipFreezeStreak


/////testing
@Preview(showBackground = true)
@Composable
fun PreviewUnlockedGiftScreen() {
    UnlockedGiftScreen(rememberNavController())
}
/////////

// Use UnlockedGiftScreen() as main
@Composable
fun UnlockedGiftScreen(navController: NavController) {
    val rawComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.animation_snow)
    )

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val guideline = createGuidelineFromTop(0.2f)
        val (imageView, imageTitle, textDesc, buttonStarted) = createRefs()

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(220.dp)
                .constrainAs(imageView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(guideline)
                }, contentScale = ContentScale.Inside,
            iterations = Int.MAX_VALUE
        )
        Text(text = stringResource(R.string.title_unlock_gift),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(imageTitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageView.bottom)
                })

        Text(text = stringResource(R.string.subtitle_unlock_gift),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(textDesc) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageTitle.bottom)
                })

        Button(onClick = {

        },
            colors = ButtonDefaults.buttonColors(Btn_EquipFreezeStreak),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonStarted) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(16.dp)) {
            Text(
                text = stringResource(R.string.btn_unlock_gift),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }

    }

}