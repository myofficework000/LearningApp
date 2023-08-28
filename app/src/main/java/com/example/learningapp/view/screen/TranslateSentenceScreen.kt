package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.WordItem
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.GreyWhite
import com.example.learningapp.view.theme.LightGrey


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TranslateSentenceBrother(navController: NavController){

    val initialWords = listOf(
        WordItem("mkhulu"),
        WordItem("yebo"),
        WordItem("Bhuti"),
        WordItem("hambha kahle"),
        WordItem("sawubona")

    )
    var availableWords by remember { mutableStateOf(initialWords) }
    var selectedWords by remember { mutableStateOf("") }
    var checkButtonBackground by remember { mutableStateOf(Color.LightGray) }


    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (textSentence, imageGirl, textBrother, dividerOne, dividerTwo, dividerThree,
            btnSkip, btnCheck,sentenceRow,wordsRow) = createRefs()

        val guideline2 = createGuidelineFromTop(0.6f)

        Text(text = stringResource(R.string.translate_sentence),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .constrainAs(textSentence) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .padding(start = 28.dp, top = 24.dp, end = 8.dp))


        Image(painter = painterResource(R.drawable.women_translate_sentence),
            contentDescription = " Img ",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(top = 24.dp)
                .height(150.dp)
                .width(150.dp)
                .constrainAs(imageGirl) {
                    start.linkTo(parent.start)
                    top.linkTo(textSentence.bottom)
                })

        Text(text = stringResource(R.string.brother),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .constrainAs(textBrother) {
                    start.linkTo(imageGirl.end)
                    top.linkTo(textSentence.bottom)
                }
                .padding(start = 16.dp, top = 70.dp,))

        Divider(
            modifier = Modifier
                .constrainAs(dividerOne) {
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(imageGirl.bottom)
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
            if(selectedWords.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .background(Color.Transparent)
                        .padding(16.dp)
                ) {
                    Text(selectedWords)
                }
            }
        }

        Divider(
            modifier = Modifier
                .constrainAs(dividerTwo) {
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(dividerOne.bottom, 60.dp)
                    width = Dimension.fillToConstraints
                })

        Divider(
            modifier = Modifier
                .constrainAs(dividerThree) {
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(dividerTwo.bottom, 60.dp)
                    width = Dimension.fillToConstraints
                })

        FlowRow(
            modifier = Modifier
                .constrainAs(wordsRow){
                    start.linkTo(parent.start, 50.dp)
                    end.linkTo(parent.end, 50.dp)
                    top.linkTo(guideline2, 30.dp)
                },
            maxItemsInEachRow = 3,
            horizontalArrangement = Arrangement.Center
        ) {
            availableWords.forEach{wordItem ->
                Box(
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .background(wordItem.backgroundColor, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .clickable {
                            checkButtonBackground = Green40
                            if (!wordItem.isClicked) {
                                selectedWords = wordItem.word
                                wordItem.isClicked = true
                                availableWords = availableWords.map {
                                    if(it.word != wordItem.word) {
                                        it.isClicked = false
                                    }
                                    it
                                }
                            }
                        }
                        .padding(16.dp)
                ) {
                    Text(if (wordItem.isClicked) wordItem.placeholder else wordItem.word)
                }
            }
        }

        OutlinedButton(
            onClick = {  },
            border = BorderStroke(1.dp,LightGrey),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.constrainAs(btnSkip) {
                start.linkTo(parent.start, 10.dp)
                bottom.linkTo(parent.bottom, 10.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(R.string.skip),
                color = LightGrey,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                GreyWhite
            ),
            modifier = Modifier.constrainAs(btnCheck) {
                end.linkTo(parent.end, 10.dp)
                start.linkTo(btnSkip.end)
                bottom.linkTo(parent.bottom, 10.dp)
                width = Dimension.fillToConstraints
            }.padding(start = 4.dp)
        ) {
            Text(text = stringResource(R.string.check), color = LightGrey,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}