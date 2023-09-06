package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
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
    val amountRefillNeeded by remember { mutableIntStateOf(200) }
    val amountPossessed by remember { mutableIntStateOf(500) }


    val images = listOf(
        R.drawable.streak_freeze_selected,
        R.drawable.streak_freeze_unselected
    )
    var equippedNum by remember { mutableIntStateOf(0) }

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (noThanksButton, refillButton, refillOptionBox, possessedDiamond) = createRefs()
        Row(
            modifier = Modifier
                .constrainAs(possessedDiamond) {
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
            onClick = {},
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
                    text = "refill $amountRefillNeeded",
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
            Text(text = stringResource(R.string.no_thanks), color = Blue100)
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
                text = stringResource(R.string.streak_freeze_used),
                Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Get more to keep your 1 day streak protected. You have $equippedNum of 2 equipped",
                Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Row {
                ClickableImageChanger(images = images, current = 1, object : OnChangeCallBack {
                    override fun update(isSelected: Boolean) {
                        if (isSelected) {
                            equippedNum++
                        } else {
                            equippedNum--
                        }
                    }
                })
                Spacer(modifier = Modifier.padding(20.dp))
                ClickableImageChanger(images = images, current = 1, object : OnChangeCallBack {
                    override fun update(isSelected: Boolean) {
                        if (isSelected) {
                            equippedNum++
                        } else {
                            equippedNum--
                        }
                    }
                })
            }

        }
    }
}

@Composable
fun ClickableImageChanger(
    images: List<Int>,
    current: Int,
    onChangeCallBack: OnChangeCallBack
) {
    var currentImageIndex by remember { mutableIntStateOf(current) }
    var isSelected by remember { mutableStateOf(false) }
    val currentImage = images[currentImageIndex]

    Image(
        painter = painterResource(id = currentImage),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clickable {
                currentImageIndex = (currentImageIndex + 1) % images.size
                isSelected = !isSelected
                onChangeCallBack.update(isSelected)
            }
    )
}

interface OnChangeCallBack {
    fun update(isSelected: Boolean)
}
