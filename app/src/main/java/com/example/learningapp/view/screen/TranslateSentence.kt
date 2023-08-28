package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.modal.dto.WordItem
import com.example.learningapp.view.theme.Green40
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TranslateSentence(navController: NavController){
    val initialWords = listOf(
        WordItem("Max"),
        WordItem("brother"),
        WordItem("are"),
        WordItem("I"),
        WordItem("Hello"),
        WordItem("mom")
    )
    var availableWords by remember { mutableStateOf(initialWords) }
    var selectedWords by remember { mutableStateOf(mutableListOf<String>()) }
    var checkButtonBackground by remember { mutableStateOf(Color.LightGray) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val guideline = createGuidelineFromStart(0.3f)
        val guideline2 = createGuidelineFromTop(0.6f)
        val (containerGirl, dividerOne, dividerTwo, dividerThree, sentenceRow, wordsRow, skipButton, checkButton) = createRefs()
        GirlContainer(modifier = Modifier.constrainAs(containerGirl){
            top.linkTo(parent.top, 10.dp)
            start.linkTo(parent.start)
        })
        Divider(
            modifier = Modifier
                .constrainAs(dividerOne){
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(containerGirl.bottom)
                    width = Dimension.fillToConstraints
            })

        Row(
            modifier = Modifier
                .constrainAs(sentenceRow){
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    bottom.linkTo(dividerTwo.bottom, 5.dp)
                    width = Dimension.fillToConstraints
                }
        ) {
            selectedWords.forEach { word ->
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .background(Color.Transparent)
                        .padding(16.dp)
                ) {
                    Text(word)
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }

        Divider(
            modifier = Modifier
                .constrainAs(dividerTwo){
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(dividerOne.bottom, 60.dp)
                    width = Dimension.fillToConstraints
                })

        Divider(
            modifier = Modifier
                .constrainAs(dividerThree){
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(dividerTwo.bottom, 60.dp)
                    width = Dimension.fillToConstraints
                })

        FlowRow(
            modifier = Modifier
                .constrainAs(wordsRow){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(guideline2, 30.dp)
                },
            maxItemsInEachRow = 5,
            horizontalArrangement = Arrangement.Center
        ) {
            availableWords.forEach{wordItem ->
                Box(
                    modifier = Modifier
                        .background(wordItem.backgroundColor, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .clickable {
                            checkButtonBackground = Green40
                            if (!wordItem.isClicked) {
                                val updatedSelectedWords = selectedWords.toMutableList()
                                updatedSelectedWords.add(wordItem.word)
                                selectedWords = updatedSelectedWords
                                wordItem.isClicked = true
                            } else {
                                val updatedSelectedWords = selectedWords.toMutableList()
                                updatedSelectedWords.remove(wordItem.word)
                                selectedWords = updatedSelectedWords
                                wordItem.isClicked = false
                            }
                        }
                        .padding(16.dp)
                ) {
                    Text(if (wordItem.isClicked) wordItem.placeholder else wordItem.word)
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier.constrainAs(skipButton) {
                start.linkTo(parent.start, 10.dp)
                end.linkTo(guideline)
                bottom.linkTo(parent.bottom, 10.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(R.string.skip))
        }
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = checkButtonBackground
            ),
            modifier = Modifier.constrainAs(checkButton) {
                start.linkTo(guideline, 10.dp)
                end.linkTo(parent.end, 10.dp)
                bottom.linkTo(parent.bottom, 10.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(R.string.check))
        }


    }
}

@Composable
fun GirlContainer(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (animationGirl, soundImage, txtHearing) = createRefs()
        GirlAnimation(Modifier.constrainAs(animationGirl) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Image(
            modifier = Modifier
                .size(20.dp)
                .constrainAs(soundImage) {
                    start.linkTo(animationGirl.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(id = R.drawable.ic_audio),
            contentDescription = "audio")
        Text(text = stringResource(R.string.zulu),
            modifier = Modifier.constrainAs(txtHearing) {
                start.linkTo(soundImage.end, 10.dp)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
    }
}

@Composable
fun GirlAnimation(modifier: Modifier) {
    val rawComposition
            by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.girl_in_purple))

    LottieAnimation(
        composition = rawComposition,
        contentScale = ContentScale.Fit,
        iterations = Int.MAX_VALUE,
        modifier = modifier
            .width(width = 200.dp)
            .height(height = 200.dp)
    )
}