package com.example.learningapp.view.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.learningapp.view.theme.darkGreen

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
                    color = darkGreen,
                    shape = CircleShape,
                    border = BorderStroke(1.dp, color = darkGreen)
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

            TextField(
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

            TextField(
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

            TextField(
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

            TextField(
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
                    .padding(horizontal = 10.dp,)
            ) {
                Text(text = "DUOLINGO FOR SCHOOLS",
                    fontWeight = FontWeight.Bold,
                    color = ColorBlue)
            }
            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp,)
            ) {
                Text(text = "SIGN OUT",
                    fontWeight = FontWeight.Bold,
                    color = ColorBlue)
            }

            Text(
                text = "General",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
            General(Modifier.fillMaxWidth())

            Text(
                text = "Accessibility",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

        }
    }

}


@Composable
fun General(modifier: Modifier){
    val checked = remember { mutableStateOf(true) }

    Column {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Column {
                Row {
                    Text(
                        text = "Sound Effects",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
                        modifier = Modifier,
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                    )

                }
                Divider(
                    color = Color.Blue, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )
                Row {
                    Text(
                        text = "DARK MODE",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Text(
                        text = "System Default",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                }
                Divider(
                    color = Color.Blue, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )

                Row {
                    Text(
                        text = "Friends Quest",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
                        modifier = Modifier,
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                    )

                }
                Divider(
                    color = Color.Blue, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )

                Row {
                    Text(
                        text = "Motivational messages",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
                        modifier = Modifier,
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                    )

                }


            }

        }
        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp,)
        ) {
            Text(text = "HELP CENTER",
                fontWeight = FontWeight.Bold,
                color = ColorBlue)
        }

        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp,)
        ) {
            Text(text = "MANAGE COURSES",
                fontWeight = FontWeight.Bold,
                color = ColorBlue)
        }
        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp,)
        ) {
            Text(text = "FEEDBACK",
                fontWeight = FontWeight.Bold,
                color = ColorBlue)
        }

    }

}