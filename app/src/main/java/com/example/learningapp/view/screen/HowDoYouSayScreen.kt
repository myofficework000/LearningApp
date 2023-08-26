package com.example.learningapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.view.theme.GreyButtonText
import com.example.learningapp.view.theme.TextGray
import com.example.learningapp.view.theme.White

@Composable
fun HowDoYouSay(navController: NavController) {

    val words = getWords()

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (fieldText, fieldBox, fieldButton) = createRefs()

        Text(text = stringResource(R.string.how_do_you_say_sister),
            modifier = Modifier
                .constrainAs(fieldText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(20.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold)

        Box(Modifier.constrainAs(fieldBox){
            top.linkTo(fieldText.bottom)
            bottom.linkTo(fieldButton.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        }) {
            LazyColumn(
                Modifier){
                items(words) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                            .padding(10.dp)
                            .clickable { },
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(containerColor = White)
                    ) {
                        Box(Modifier.fillMaxWidth()) {
                            Text(
                                text = item.word,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center)
                                    .padding(8.dp),
                                fontSize = 20.sp,
                                color = TextGray
                            )
                        }
                    }
                }
            }
        }

        Button(
            onClick = { },
            colors= ButtonDefaults.buttonColors(GreyButtonText),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(fieldButton) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.check_str),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

data class Words(val word: String)

@Composable
fun getWords() = listOf(
    Words("sisi"),
    Words("sawubona"),
    Words("bhuti")
)