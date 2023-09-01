package com.example.learningapp.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.modal.dto.TipCard
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.LightBlue1

@Composable
@Preview
fun Tip() {
    val title by remember { mutableStateOf("Spanish Sounds") }
    val description by remember { mutableStateOf("Spanish pronunciation is easier than you think! In general, Spanish vowels are always pronounced the same way.") }
    val exampleCard by remember { mutableStateOf(TipCard("a", "adios", "adios")) }
    val example by remember {
        mutableStateOf("For example, the ${exampleCard.char} in ${exampleCard.word} sounds the same as the a in cama.")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(LightBlue1)) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "TIP", color = Blue100, fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = description,
                fontSize = 15.sp,
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = example,
                fontSize = 15.sp,
            )

            LazyColumn(Modifier.padding(10.dp)) {
                items(getTipCards()) {
                    tipCard(it)
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}


@Composable
fun tipCard(tip: TipCard) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (charBox, word, sentence) = createRefs()
        Box(
            modifier = Modifier
                .size(80.dp)
                .shadow(20.dp)
                .background(Blue100, RoundedCornerShape(8.dp))
                .constrainAs(charBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        ) {
            Text(
                text = tip.char,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 30.sp
            )
            Icon(
                imageVector = Icons.Filled.Campaign,
                contentDescription = "listen",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(3.dp)
                    .height(15.dp)
                    .width(15.dp),
                tint = Color.White
            )
        }
        Text(
            text = buildAnnotatedString {
                customStringBuilder(tip.word, tip.char)
            },
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.constrainAs(word) {
                top.linkTo(charBox.top)
                bottom.linkTo(charBox.bottom)
                start.linkTo(charBox.end, 20.dp)
            }
        )
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.as_in))
                customStringBuilder(tip.asIfWord, tip.char)
            },
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(sentence) {
                    top.linkTo(charBox.bottom, 10.dp)
                    start.linkTo(charBox.start)
                }
        )
    }
}

fun AnnotatedString.Builder.customStringBuilder(sentence: String, char: String) {
    val indexes = findSubStringIndexes(sentence, char)
    val list = splitStringAtIndexes(sentence, indexes)
    pushStyle(
        style = SpanStyle(
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    )
    list.forEach {
        if (it == char) {
            pushStyle(style = SpanStyle(color = Blue100))
            append(it)
            pop()
        } else {
            append(it)
        }
    }
}

fun findSubStringIndexes(parent: String, sub: String): List<Int> {
    val indexes = mutableListOf<Int>()
    var curIndex = parent.indexOf(sub)
    while (curIndex != -1) {
        indexes.add(curIndex)
        indexes.add(curIndex + sub.length)
        curIndex = parent.indexOf(sub, curIndex + 1)
    }
    return indexes
}

fun splitStringAtIndexes(str: String, indexes: List<Int>): List<String> {
    val result = mutableListOf<String>()
    var previousIndex = 0

    for (index in indexes) {
        if (index in str.indices) {
            result.add(str.substring(previousIndex, index))
            previousIndex = index
        }
    }

    if (previousIndex < str.length) {
        result.add(str.substring(previousIndex))
    }

    return result
}

private fun getTipCards(): List<TipCard> {
    return listOf(
        TipCard("a", "cama", "father"),
        TipCard("e", "leche", "set"),
        TipCard("i", "nino", "Lisa"),
        TipCard("o", "como", "gold")
    )
}
