package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Word
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.SelectedWord

/////testing
@Preview(showBackground = true)
@Composable
fun PreviewHearAndChooseWordScreen() {
    HearAndChooseWordScreen(rememberNavController())
}
/////////

// Use HearAndChooseWordScreen() as main
@Composable
fun HearAndChooseWordScreen(navController: NavController) {
    var selectedWord by remember { mutableStateOf<Word?>(null) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (title, words, buttonContinue, buttonHear, btnNotHear) = createRefs()
        val guideline = createGuidelineFromTop(0.3f)

        Text(
            text = stringResource(R.string.what_do_you_hear),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Button(
            onClick = { },
            colors=ButtonDefaults.buttonColors(SelectedWord),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(20.dp)
                .size(100.dp)
                .constrainAs(buttonHear) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(guideline)
                }
        ) {
            Image(painter = painterResource(id = R.drawable.icons8_sound_96),
                contentDescription = "Sound Img ")
        }



        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(words) {
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonContinue.top)
                }
        ) {
            items(getListOfWord()) { currentWord ->
                WordViewHolder(
                    word = currentWord,
                    selectedWord = selectedWord,
                    onCardSelected = { selectedWord = it }
                )
            }
        }
        OutlinedButton(
            onClick = { /* Action to perform */ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            border = null,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(btnNotHear) {
                    bottom.linkTo(buttonContinue.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(text = stringResource(R.string.btn_cant_listen))
        }

        Button(
            onClick = { },
            enabled = selectedWord != null,
            colors = ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .constrainAs(buttonContinue) {
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.btn_check))
        }
    }
}
@Composable
fun WordViewHolder(
    word: Word,
    selectedWord: Word?,
    onCardSelected: (Word) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .selectable(
                selected = (selectedWord == word),
                onClick = { onCardSelected(word) }
            ),
        shape = RoundedCornerShape(8.dp),
        colors = if (selectedWord == word) CardDefaults.cardColors(SelectedWord)
                        else CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Text(text = word.word,
                fontSize = 30.sp,
                color =
                if (selectedWord == word) Color.White
                    else Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp))
        }
    }
}
fun getListOfWord()= listOf(
    Word("la"),
    Word("ba"),

)

