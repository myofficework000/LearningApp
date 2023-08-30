package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.view.theme.ColorBlue
import com.example.learningapp.view.theme.DarkGreen1

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AccountScreen(){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (Boxprofile, name, Etname) = createRefs()

        val guidLine = createGuidelineFromTop(0.2f)
        var Name by remember { mutableStateOf("") }
        var UserName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Box(
            modifier = Modifier
                .constrainAs(Boxprofile) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(guidLine)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                        .clip(CircleShape),
                    color = DarkGreen1,
                    shape = CircleShape,
                    border = BorderStroke(1.dp, color = DarkGreen1)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "A", color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Text(
                    text = " CHANGE AVTAR",
                    fontWeight = FontWeight.Bold,
                    color = ColorBlue,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )

            }
        }
        Column(modifier = Modifier.constrainAs(name) {
            top.linkTo(Boxprofile.bottom)
            start.linkTo(parent.start)
        }) {
            Text(text = "Name",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                value = Name,
                onValueChange = { Name = it },
                label = { Text("Enter name") },
                modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                maxLines = 1,
                singleLine = true
            )

            Text(text = "UserName",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                value = UserName,
                onValueChange = { UserName = it },
                label = { Text("Enter User name") },
                modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                maxLines = 1,
                singleLine = true
            )

            Text(text = "Email",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your email") },
                modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                maxLines = 1,
                singleLine = true
            )

            Text(text = "password",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                ),
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password ") },
                modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                maxLines = 1,
                singleLine = true
            )

            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                Text(text = "DUOLINGO FOR SCHOOLS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = ColorBlue, modifier = Modifier.padding(vertical = 8.dp))
            }
            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Text(text = "SIGN OUT",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ColorBlue, modifier = Modifier.padding(vertical = 8.dp))
            }

        }
    }

}