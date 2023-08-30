package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.GreyButtonText

@Composable
fun LevelUpScreen() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (fieldBox, fieldButton) = createRefs()

        Box(
            Modifier
                .constrainAs(fieldBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .wrapContentSize()) {

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.levelup_pic),
                    contentDescription = stringResource(
                    id = R.string.streak),
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp)
                        .align(CenterHorizontally)
                )

                Text(
                    text = stringResource(R.string.you_leveled_up),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 15.dp)
                )

                Text(
                    text = stringResource(R.string.you_added_a_profile_picture),
                    textAlign = TextAlign.Center,
                    color = GreyButtonText,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }

        }

        Button(
            onClick = { },
            colors= ButtonDefaults.buttonColors(Blue100),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(fieldButton) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}