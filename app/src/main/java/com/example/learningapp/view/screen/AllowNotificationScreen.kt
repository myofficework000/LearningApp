package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes
import com.example.learningapp.view.theme.Green40

@Preview
@Composable
fun AllowNotification(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        DisplayDialog()
        val (containerOwl, btnContinue) = createRefs()
        OwlContainer(modifier = Modifier.constrainAs(containerOwl) {
            top.linkTo(parent.top)
        })

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(btnContinue) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue))
        }
    }
}

@Composable
fun DisplayDialog(){
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(text = stringResource(R.string.send_notification))
                    }
                },
                confirmButton = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0x80FF5722),
                                contentColor = Color.Gray
                            ),
                            onClick = {
                                openDialog.value = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = stringResource(R.string.do_not_allow))
                        }
                    }
                },
                dismissButton = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0x808BC34A),
                                contentColor = Color.Gray
                            ),
                            onClick = {
                                openDialog.value = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = stringResource(R.string.allow))
                        }
                    }
                },
                containerColor = Color.White
        )
    }
}

@Composable
fun OwlContainer(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (animationOwl, txtHearing) = createRefs()
        OwlAnimation(Modifier.constrainAs(animationOwl) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Text(text = stringResource(R.string.reminder_notification),
            modifier = Modifier.constrainAs(txtHearing) {
                start.linkTo(animationOwl.end)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
    }
}