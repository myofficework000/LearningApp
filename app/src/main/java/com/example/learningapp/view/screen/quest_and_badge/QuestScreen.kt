package com.example.learningapp.view.screen.quest_and_badge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.learningapp.R
import com.example.learningapp.modal.dto.DailyQuest
import com.example.learningapp.modal.dto.Word
import com.example.learningapp.view.screen.WordViewHolder
import com.example.learningapp.view.screen.getListOfWord
import com.example.learningapp.view.theme.Green100
import com.example.learningapp.view.theme.Green40
import com.example.learningapp.view.theme.QuestAndBadge_TabBackGround
import com.example.learningapp.view.theme.SelectedWord
import com.example.learningapp.view.theme.TimeLeft_txt


/////testing
@Preview(showBackground = true)
@Composable
fun DemoQuestScreen() {
    QuestScreen()
}
/////////
@Composable
fun QuestScreen(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {

        val (earnRewardContainer, dailyQuestContainer) = createRefs()
        EarnRewardContainer(modifier =
            Modifier.constrainAs(earnRewardContainer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.wrapContent
            })
        DailyQuestContainer(modifier =
            Modifier.constrainAs(dailyQuestContainer) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(earnRewardContainer.bottom)
                height = Dimension.wrapContent
                width = Dimension.fillToConstraints
        })

    }
}

@Composable
fun EarnRewardContainer(modifier: Modifier){
    ConstraintLayout(modifier = modifier
        .background(QuestAndBadge_TabBackGround)
        .fillMaxWidth()){
        val ( title, subtitle, animation) = createRefs()
        val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_owl))

        Text(
            text = stringResource(R.string.earn_rewards_with_quests_title),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(animation.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                })
        Text(
            text = "You have completed 0 out of 3 quests today.",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(subtitle) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(animation.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                })

        LottieAnimation(
            composition = rawComposition,
            modifier = Modifier
                .size(150.dp)
                .constrainAs(animation) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }, contentScale = ContentScale.Inside,
            iterations = Int.MAX_VALUE
        )
    }
}

@Composable
fun DailyQuestContainer(modifier: Modifier){
    ConstraintLayout( modifier = modifier.fillMaxWidth()) {
        val ( title, timeLeft, dailyQuestList) = createRefs()

        Text(
            text = stringResource(R.string.daily_quests_title),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                })
        Text(
            text = "20 hours left",
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = TimeLeft_txt,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(timeLeft) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                })

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(dailyQuestList) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom)
                }
        ) {
            items(getListOfQuest()) { quest ->
                DailyQuestViewHolder(quest )
            }
        }
    }
}

@Composable
fun DailyQuestViewHolder(dailyQuest: DailyQuest){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        ConstraintLayout(modifier = Modifier.padding(5.dp)) {
            val (title, thumbnail, progressBar) = createRefs()

            Image(painter = painterResource(id = dailyQuest.thumbnailImg),
                contentDescription = "DailyQuest Img ",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .constrainAs(thumbnail) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }
            )
            Text(text = dailyQuest.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .constrainAs(title) {
                        start.linkTo(thumbnail.end)
                        top.linkTo(parent.top)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }
            )
            ProgressItemCard(
                dailyQuest = dailyQuest,
                modifier = Modifier.constrainAs(progressBar){
                    start.linkTo(thumbnail.end)
                    top.linkTo(title.bottom)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                })
        }

    }
}

@Composable
fun ProgressItemCard(dailyQuest: DailyQuest, modifier: Modifier) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .padding(16.dp) ,
    ) {
        LinearProgressIndicator(
            progress = dailyQuest.process.toFloat() / dailyQuest.maxProcess,
            color = Green100,
            modifier = Modifier.height(18.dp)
        )
        Text(
            text = "${dailyQuest.process} / ${dailyQuest.maxProcess}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

    }
}

fun getListOfQuest()= listOf(
    DailyQuest("Earn 10 xp",5,10,R.drawable.lighting),
    DailyQuest("Complete 1 lesson",0,1,R.drawable.nerd),
    DailyQuest(
        "Score 90% or higher in 3 lessons",9,10,R.drawable.goal),
    )


