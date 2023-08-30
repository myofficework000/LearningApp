package com.example.learningapp.view.screen.choose_section

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Section
import com.example.learningapp.view.theme.Locked_BackGround
import com.example.learningapp.view.theme.Unlocked_BackGround


@Preview(showBackground = true)
@Composable
fun PreviewSectionScreen() {
    SectionScreen(
        Section("test",
            0,
            5,
            R.drawable.ic_facebook,
            true))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SectionScreen(section: Section) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topButtonsContainer, divider, cardAndAnimation) = createRefs()
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
        CardAndAnimationContainer( section= section,
            modifier = Modifier.constrainAs(cardAndAnimation) {
                top.linkTo(divider.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
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
fun CardAndAnimationContainer(modifier: Modifier, section: Section){
    val backgroundColor = if(section.isUnlocked) Unlocked_BackGround else Locked_BackGround
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
        .background(backgroundColor)) {
        val (animation, card) = createRefs()

    }
}


