package com.example.learningapp.view.screen.guidebook

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.DailyQuest
import com.example.learningapp.modal.dto.SubjectAndVerb
import com.example.learningapp.view.screen.guidebook.Constant.DESCRIPTION
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import com.example.learningapp.view.theme.VerbGuide_Background
import com.example.learningapp.view.theme.VerbGuide_Header_Background
import com.example.learningapp.view.theme.VerbGuide_Table_Border
import com.example.learningapp.view.theme.VerbGuide_Text
import com.example.learningapp.view.theme.VerbGuide_Title_Text


@Preview(showBackground = true)
@Composable
fun PreviewVerbGuideScreen() {
    VerbGuideScreen()
}

@Composable
fun VerbGuideScreen() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .verticalScroll(state = rememberScrollState())
            .fillMaxWidth()
            .background(VerbGuide_Background)
    ) {
        Text(
            text = stringResource(R.string.verbguide_title),
            color = VerbGuide_Title_Text,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(20.dp))
        Text(
            text = stringResource(R.string.verbguide_subtitle),
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp))
        Text(
            text = stringResource(R.string.VerbScreen_description),
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp))
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp)) {
            // Here is the header
            item {
               RowHeader()
            }
            // Here are all the lines of your table.
            items(getListOfSubjectAndVerb()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White)) {
                    TableCell( subjectAndVerb = it )
                }
            }
        }
       CardWithImg()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.icons8_sound_100),
                contentDescription = "Icon"
            )
            Spacer(modifier = Modifier.width(16.dp)) // Add spacing between icon and text
            Text(
                text = "Yo soy una niña. Tú eres un nino.",
                color = Color.Black,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
            )
        }
        Text(
            text = stringResource(R.string.VerbScreen_Example),
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}
@Composable
fun RowHeader(){
    Row(
        modifier = Modifier
            .background(VerbGuide_Header_Background)
    ) {
        Text(
            text = "subject",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .border(1.dp, VerbGuide_Table_Border)
                .weight(0.5f)
                .padding(10.dp)
        )
        Text(
            text = "verb (ser)",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .border(1.dp, VerbGuide_Table_Border)
                .weight(0.5f)
                .padding(10.dp)
        )
    }
}
@Composable
fun RowScope.TableCell(
    subjectAndVerb: SubjectAndVerb
    ) {
    Column(modifier = Modifier
        .border(1.dp, VerbGuide_Table_Border)
        .weight(0.5f)
        .padding(10.dp)) {
        Text(
            text = subjectAndVerb.subjectPronunciation,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)
        Text( text = subjectAndVerb.subject )

    }
    Column(modifier = Modifier
        .border(1.dp, VerbGuide_Table_Border)
        .weight(0.5f)
        .padding(10.dp)) {
        Text(
            text = subjectAndVerb.verbPronunciation,
            textDecoration = TextDecoration.Underline,
            color =VerbGuide_Text,
            fontWeight = FontWeight.Bold)
        Text( text = subjectAndVerb.verb )

    }
}


@Composable
fun CardWithImg(){
    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, VerbGuide_Table_Border),
        elevation = CardDefaults.cardElevation(5.dp))
    {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.conversation),
                contentDescription = "Sound Img ",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
fun getListOfSubjectAndVerb() = listOf(
    SubjectAndVerb("I","yo","I am", "soy"),
    SubjectAndVerb("you","tú","you are", "eres"),
    SubjectAndVerb("he","él","he is", "es"),
    SubjectAndVerb("she","ella","she is", "es")

)
