package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.learningapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInEmailScreen(navController: NavController) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPwdVisible by remember { mutableStateOf(false) }
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (staticText, areaInfo, forgotPwdButton, signInButton, googleButton, facebookButton) = createRefs()

        Text(
            fontSize = 25.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .constrainAs(staticText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Enter your details"
        )

        Column(
            Modifier.constrainAs(areaInfo) {
                top.linkTo(staticText.bottom, 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Username or email") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                visualTransformation = (if (isPwdVisible) VisualTransformation.None else PasswordVisualTransformation()),
                label = { Text("Password") },
                trailingIcon = {
                    IconButton(onClick = { isPwdVisible = !isPwdVisible }) {
                        if (isPwdVisible) {
                            Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                        } else {
                            Icon(imageVector = Icons.Outlined.Clear, contentDescription = "")
                        }
                    }
                }
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.DarkGray
            ),
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(signInButton) {
                    top.linkTo(areaInfo.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text("SIGN IN")
        }

        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            onClick = {},
            modifier = Modifier.constrainAs(forgotPwdButton) {
                top.linkTo(signInButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "FORGOT PASSWORD")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            onClick = { /* Handle Google login */ },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp) // Define rounded corners here
                )
                .constrainAs(googleButton) {
                    bottom.linkTo(facebookButton.top, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Logo",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text("SIGN IN WITH GOOGLE")
            }
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp)
                )
                .constrainAs(facebookButton) {
                    bottom.linkTo(parent.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook Logo",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text("SIGN IN WITH FACEBOOK")
            }
        }

    }
}