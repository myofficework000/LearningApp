package com.example.learningapp.view.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes.FRESH_START_SCREEN
import com.example.learningapp.view.theme.GreyWhite
import com.example.learningapp.view.theme.LightGrey

@Composable
fun KnowledgeScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val guideline = createGuidelineFromTop(0.03f)
        val (animationOwl, textSpanish, text1, text2, text3, text4, btnContinue) = createRefs()
        val rawComposition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.animation_owl)
        )

        LottieAnimation(
            composition = rawComposition,
            contentScale = ContentScale.Fit,
            iterations = Int.MAX_VALUE,
            modifier = Modifier
                .width(width = 150.dp)
                .height(height = 150.dp)
                .constrainAs(animationOwl) {
                    start.linkTo(parent.start)
                    top.linkTo(guideline)
                }
        )
        Text(text = stringResource(id = R.string.knowledge_screen_title),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(textSpanish) {
                    start.linkTo(animationOwl.end)
                    end.linkTo(parent.end)
                    top.linkTo(animationOwl.top)
                    width = Dimension.fillToConstraints
                }
                .padding(start = 24.dp, top = 24.dp, end = 8.dp))


        KnowledgeAboutSpanish(text = stringResource(id = R.string.knowledge_text1),
            img = R.drawable.strength_one,
            Modifier.constrainAs(text1) {
                start.linkTo(parent.start)
                top.linkTo(animationOwl.bottom)
                end.linkTo(parent.end)
            })
        KnowledgeAboutSpanish(text = stringResource(id = R.string.knowledge_text2),
            img = R.drawable.strength_two,
            Modifier.constrainAs(text2) {
                start.linkTo(parent.start)
                top.linkTo(text1.bottom)
                end.linkTo(parent.end)
            })
        KnowledgeAboutSpanish(text = stringResource(id = R.string.knowledge_text3),
            img = R.drawable.strength_three,
            Modifier.constrainAs(text3) {
                start.linkTo(parent.start)
                top.linkTo(text2.bottom)
                end.linkTo(parent.end)
            })
        KnowledgeAboutSpanish(text = stringResource(id = R.string.knowledge_text4),
            img = R.drawable.strength_four,
            Modifier.constrainAs(text4) {
                start.linkTo(parent.start)
                top.linkTo(text3.bottom)
                end.linkTo(parent.end)
            })

        Button(onClick = { navController.navigate(FRESH_START_SCREEN) },
            colors = ButtonDefaults.buttonColors(GreyWhite),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(btnContinue) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(horizontal = 16.dp, vertical = 16.dp)) {
            Text(
                text = stringResource(id = R.string.Button_Continue_Caps),
                color = LightGrey,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

    }


}

@Composable
fun KnowledgeAboutSpanish(text: String, @DrawableRes img: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (strengths, knowledgeAboutSpanish) = createRefs()
            Image(painter = painterResource(id = img),
                contentDescription = "hearFrom Img ",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .constrainAs(strengths) { start.linkTo(parent.start) })

            Spacer(modifier = Modifier.size(10.dp))

            Text(text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(knowledgeAboutSpanish) {
                        top.linkTo(parent.top)
                        start.linkTo(strengths.end)
                        bottom.linkTo(parent.bottom)
                    })
        }
    }

}
