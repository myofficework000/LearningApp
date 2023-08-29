package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.view.theme.Blue50

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomSheetDemo() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }
    val amountRefillNeeded by remember { mutableIntStateOf(200) }
    val amountPossessed by remember { mutableIntStateOf(500) }


    ModalBottomSheet(onDismissRequest = { /* Executed when the sheet is dismissed */ }) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (noThanksButton, refillButton, refillOptionBox, possessedDiamond) = createRefs()
            Row(
                modifier = Modifier
                    .constrainAs(possessedDiamond){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.blue_diamond),
                    contentDescription = null,
                    Modifier.size(25.dp)
                )
                Text(
                    text = " $amountPossessed",
                    color = Blue50,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .constrainAs(refillButton) {
                        bottom.linkTo(noThanksButton.top, 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Row {
                    Text(
                        text = "refill $amountRefillNeeded  ",
                        color = Blue50,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.blue_diamond),
                        contentDescription = null,
                        Modifier.size(25.dp)
                    )
                }
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .constrainAs(noThanksButton) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(text = "NO THANKS", color = Blue100)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(refillOptionBox) {
                        bottom.linkTo(noThanksButton.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Streak Freeze Used",
                    Modifier
                        .padding(30.dp)
                        .fillMaxWidth(),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Get more to keep your 1 day streak protected. You have 1 of 2 equipped",
                    Modifier
                        .padding(30.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.streak_freeze_selected),
                        contentDescription = "Google Logo",
                        modifier = Modifier
                            .size(80.dp)
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.streak_freeze_unselected),
                        contentDescription = "Google Logo",
                        modifier = Modifier
                            .size(80.dp)
                    )
                }

            }
        }
    }


}