package com.example.learningapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SignInScreen(){
    var areaCode by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var verificationCode by remember { mutableStateOf("") }
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        val (areaCodeField, mobileNumberField, getCodeButton, verificationCodeField, signInButton, googleButton, facebookButton, emailButton) = createRefs()
        val guideline = createGuidelineFromStart(0.2f)
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            ),
            value = areaCode,
            onValueChange = { areaCode = it },
            label = { Text("+91") },
            modifier = Modifier.constrainAs(areaCodeField) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.wrapContent
            },
            maxLines = 1,
            singleLine = true
        )
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            ),
            value = mobileNumber,
            onValueChange = { mobileNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.constrainAs(mobileNumberField) {
                top.linkTo(areaCodeField.top)
                start.linkTo(guideline, 8.dp)
                end.linkTo(parent.end)
            },
            maxLines = 1,
            singleLine = true,
            trailingIcon = {
                TextButton(onClick = {  }) {
                    Text("GET CODE")
                }
            }
        )
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            ),
            value = verificationCode,
            onValueChange = { verificationCode = it },
            label = { Text("Verification Code") },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(verificationCodeField) {
                    top.linkTo(mobileNumberField.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            maxLines = 1,
            singleLine = true
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE4E4E4),
                contentColor = Color(0xFFB4B4B4)
            ),
            onClick = {   },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(signInButton) {
                    top.linkTo(verificationCodeField.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text("SIGN IN")
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
            onClick = { /* Handle Facebook login */ },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp) // Define rounded corners here
                )
                .constrainAs(facebookButton) {
                    bottom.linkTo(emailButton.top, 16.dp)
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

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            onClick = { /* Handle Email login */ },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp) // Define rounded corners here
                )
                .constrainAs(emailButton) {
                    bottom.linkTo(parent.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_mail),
                    contentDescription = "Email Logo",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text("SIGN IN WITH EMAIL")
            }
        }


        }

    }
