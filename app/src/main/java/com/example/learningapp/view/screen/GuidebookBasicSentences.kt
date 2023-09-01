package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.view.screen.utils.OwlAnimation

@Preview
@Composable
fun GuidebookBasicSentences() {
    val sentences = mapOf(
        stringResource(R.string.spanish_sentence_1) to stringResource(R.string.english_sentence_1),
        stringResource(R.string.spanish_sentence_2) to stringResource(R.string.english_sentence_2),
        stringResource(R.string.spanish_sentence_3) to stringResource(R.string.english_sentence_3)
    )
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (closeButton, containerOwl, titleText, subtitleText, divider, keyPhrases, formSentences, sentenceColumn) = createRefs()
        IconButton(
            modifier = Modifier
                .constrainAs(closeButton){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            onClick = { /*TODO*/ }
        ) {
            Icon(
                tint = Color.Gray,
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
        OwlAnimation(Modifier.constrainAs(containerOwl){
            top.linkTo(closeButton.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(
            modifier = Modifier
                .constrainAs(titleText){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(containerOwl.bottom)
                },
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            text = stringResource(R.string.unit_1_guidebook))

        Text(
            modifier = Modifier
                .constrainAs(subtitleText){
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(titleText.bottom, 10.dp)
                },
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 18.sp,
            text = stringResource(R.string.explore_grammar_tips))

        Divider(
            modifier = Modifier
                .constrainAs(divider){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(subtitleText.bottom, 20.dp)
                    width = Dimension.fillToConstraints
                }
        )

        Text(
            modifier = Modifier
                .constrainAs(keyPhrases){
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(divider.bottom, 20.dp)
                },
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            fontSize = 18.sp,
            text = stringResource(R.string.key_phrases_ss)
        )

        Text(
            modifier = Modifier
                .constrainAs(formSentences){
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(keyPhrases.bottom, 10.dp)
                },
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            text = stringResource(R.string.form_sentences)
        )

        Column(
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(sentenceColumn) {
                    top.linkTo(formSentences.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
        ) {
            sentences.forEach{ pair ->
                Row(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
                ) {
                    Image(
                        modifier = Modifier
                            .size(30.dp)
                            .padding(5.dp),
                        painter = painterResource(R.drawable.ic_audio),
                        contentDescription = null)
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(5.dp),
                            fontSize = 15.sp,
                            text = pair.key
                        )
                        Text(
                            modifier = Modifier
                                .padding(5.dp),
                            fontSize = 15.sp,
                            text = pair.value,
                            color = Color.Gray
                        )
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}