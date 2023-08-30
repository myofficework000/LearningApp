package com.example.learningapp.view.screen.choose_section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.modal.dto.DailyQuest
import com.example.learningapp.modal.dto.Section
import com.example.learningapp.view.theme.Green100
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.Locked_BackGround
import com.example.learningapp.view.theme.Locked_Card_BackGround
import com.example.learningapp.view.theme.Locked_Card_Button_txt
import com.example.learningapp.view.theme.Locked_txt
import com.example.learningapp.view.theme.Unlocked_BackGround
import com.example.learningapp.view.theme.Unlocked_Card_BackGround
import com.example.learningapp.view.theme.Unlocked_Card_Button_txt
import com.example.learningapp.view.theme.Unlocked_txt


@Preview(showBackground = true)
@Composable
fun PreviewSectionScreen() {
    SectionScreen(
        Section("test",
            "sadfasdf",
            0,
            5,
            R.drawable.ic_facebook,
            true))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SectionScreen(section: Section) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topButtonsContainer, divider, cardAndImage) = createRefs()
        TopButtonsContainer( isUnlocked = section.isUnlocked,
            modifier = Modifier.constrainAs(topButtonsContainer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            })
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .height(2.dp)
                .constrainAs(divider) {
                    top.linkTo(topButtonsContainer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        CardAndImageContainer( section= section,
            modifier = Modifier.constrainAs(cardAndImage) {
                top.linkTo(divider.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

    }

}

@Composable
fun TopButtonsContainer(modifier: Modifier, isUnlocked: Boolean){
    val backgroundColor = if(isUnlocked) Unlocked_BackGround else Locked_BackGround
    ConstraintLayout( modifier = modifier
        .fillMaxWidth()
        .background(backgroundColor)) {
        val (chooseLanguage, steak,diamond, heart) = createRefs()
        val guideline = createGuidelineFromStart(0.5f)
        OutlinedButton(
            onClick = { /* Action to perform */ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            border = null,
            modifier = Modifier.constrainAs(chooseLanguage){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            Icon(Icons.Default.Flag, contentDescription = "Language")
        }

        OutlinedButton(
            onClick = { /* Action to perform */ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            border = null,
            modifier = Modifier
                .constrainAs(steak){
                top.linkTo(parent.top)
                start.linkTo(chooseLanguage.end)
                end.linkTo(guideline)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            Icon(Icons.Default.LocalFireDepartment, contentDescription = "Search")
            Text(text ="1",modifier = Modifier.padding(horizontal = 5.dp))
        }
        OutlinedButton(
            onClick = { /* Action to perform */ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            border = null,
            modifier = Modifier.constrainAs(diamond){
                top.linkTo(parent.top)
                end.linkTo(heart.start)
                start.linkTo(guideline)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            Icon(Icons.Default.Diamond,tint = Color.Blue, contentDescription = "Search")
            Text(text = "500",modifier = Modifier.padding(horizontal = 5.dp))
        }
        OutlinedButton(
            onClick = { /* Action to perform */ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            border = null,
            modifier = Modifier.constrainAs(heart){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        ) {
            Icon(Icons.Default.HeartBroken,tint= Color.Red, contentDescription = "Search")
            Text(text = "5",modifier = Modifier.padding(horizontal = 5.dp))
        }
    }

}

@Composable
fun CardAndImageContainer(modifier: Modifier, section: Section){
    val backgroundColor = if(section.isUnlocked) Unlocked_BackGround else Locked_BackGround
    ConstraintLayout(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)) {
        val (img, card) = createRefs()
        Image(painter = painterResource(id = section.thumbnailImg),
            contentDescription = "hearFrom Img ",
            modifier = Modifier
                .size(200.dp)
                .padding(vertical = 20.dp)
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)

                }
        )
        CardContainer( section = section,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(card) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(img.bottom)
                })

    }
}

@Composable
fun CardContainer(modifier: Modifier, section: Section){
    val textColor = if(section.isUnlocked) Unlocked_txt else Locked_txt
    val btnTextColor = if(section.isUnlocked) Unlocked_Card_Button_txt else Locked_Card_Button_txt
    val backgroundColor = if(section.isUnlocked) Unlocked_Card_BackGround else Locked_Card_BackGround
    Card(
        colors = CardDefaults.cardColors(backgroundColor),
        modifier = modifier
            .padding(vertical = 20.dp)
            .wrapContentSize(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
        ) {
            val (title , progressBar, description, button) = createRefs()
            Text(text = section.title,
                fontSize = 30.sp,
                color = textColor,
                modifier= Modifier
                    .padding(20.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    })
            ProgressItemCard(section= section,
                modifier = Modifier.constrainAs(progressBar){
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text(text = section.description,
                fontSize = 15.sp,
                color = textColor,
                modifier= Modifier
                    .padding(20.dp)
                    .constrainAs(description) {
                        top.linkTo(progressBar.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    })

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .padding(20.dp)
                    .constrainAs(button) {
                        top.linkTo(description.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
            ) {
                Text(text = "Start" ,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = btnTextColor,
                    modifier= Modifier)
            }

        }

    }
}
@Composable
fun ProgressItemCard(modifier: Modifier, section: Section) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .padding(24.dp),
    ) {
        LinearProgressIndicator(
            progress = section.currentUnit.toFloat() / section.maxUnit,
            color = Green100,
            modifier = Modifier
                .height(24.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "${section.currentUnit} / ${section.maxUnit} UNITS",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .align(Alignment.Center)
        )

    }
}




