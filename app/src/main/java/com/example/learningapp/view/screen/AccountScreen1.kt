package com.example.learningapp.view.screen


import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.view.screen.utils.deleteSharedPref
import com.example.learningapp.view.theme.ColorBlue
import com.example.learningapp.view.theme.darkGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController: NavController,context: Context){
    val state = rememberScrollState()
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state)) {
        val (Boxprofile, name) = createRefs()

        val guidLine = createGuidelineFromTop(0.1f)
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
                    .fillMaxWidth()
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
                    .fillMaxWidth()
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
                    .fillMaxWidth()
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
                    .fillMaxWidth()
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
            OutlinedButton(onClick = {
                context.deleteSharedPref()
            },
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

            Accessibility(Modifier.fillMaxWidth())

            Text(
                text = "Connected",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
            Connected(Modifier.fillMaxWidth())


            Text(
                text = "Notifications",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
            Notifications(Modifier.fillMaxWidth())

            Text(
                text = "Privacy",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )

            Privacy(Modifier.fillMaxWidth())


        }
    }

}

@Preview(showBackground = true)
@Composable
fun General(modifier: Modifier= Modifier){
    val checked = remember { mutableStateOf(true) }
    val checked1 = remember { mutableStateOf(true) }
    val checked2 = remember { mutableStateOf(true) }

    Column {
        Card(

            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Sound Effects",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
//                        modifier = Modifier.align(alignment = Alignment.End),
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                    )

                }
                Divider(
                    color =Color.LightGray, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )
                Row( modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(
                        text = "DARK MODE",
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Text(
                        text = "System Default",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                }
                Divider(
                    color = Color.LightGray, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Friends Quest",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
                        modifier = Modifier,
                        checked = checked1.value,
                        onCheckedChange = { checked1.value = it },
                    )

                }
                Divider(
                    color = Color.LightGray, modifier = Modifier
                        .fillMaxWidth()
                        .width(2.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Motivational messages",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Switch(
                        modifier = Modifier,
                        checked = checked2.value,
                        onCheckedChange = { checked2.value = it },
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

@Composable
fun Accessibility(modifier: Modifier){

    val checked = remember { mutableStateOf(true) }
    val checked1 = remember { mutableStateOf(true) }
    val checked2 = remember { mutableStateOf(true) }
    val checked3 = remember { mutableStateOf(true) }
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        Column {
            Row(  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Speaking Exercises",
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
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )
            Row(  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Learning Exercises",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Switch(
                    modifier = Modifier,
                    checked = checked1.value,
                    onCheckedChange = { checked1.value = it },
                )

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row(  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Animations ",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Switch(
                    modifier = Modifier,
                    checked = checked2.value,
                    onCheckedChange = { checked2.value = it },
                )

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Haptic Feedback ",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Switch(
                    modifier = Modifier,
                    checked = checked3.value,
                    onCheckedChange = { checked3.value = it },
                )

            }


        }

    }
}

@Composable
fun Connected(modifier: Modifier) {
    val checked = remember { mutableStateOf(true) }

    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        Column {
            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.contacts), contentDescription = "Image")
                Text(
                    text = "Speaking Exercises",
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
}

@Composable
fun Notifications(modifier: Modifier){
    val checked = remember { mutableStateOf(true) }
    val checked1 = remember { mutableStateOf(true) }

    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        Column {
            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "SMS Remainder",
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
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        Column {
            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Practice remainder",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )


                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )
            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Smart Scheduling",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Switch(
                    modifier = Modifier,
                    checked = checked1.value,
                    onCheckedChange = { checked1.value = it },
                )

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Remainder Time ",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Text(
                    text = "0:00 ",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )
        }
    }

    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        Column {
            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Weekly Progress",

                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )


            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "New Follower",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Friend Activity",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Leaderboards ",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")


            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Product updates + learning tips",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "news + Promotions",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Streak Freeze used",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Streak Saver",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_phone_android_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

            Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Research Invitations",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_mail_24), contentDescription = "Image")

            }
            Divider(
                color = Color.LightGray, modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun Privacy(modifier: Modifier = Modifier){
    val checked = remember { mutableStateOf(true) }

    Column() {

        Card(
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {

            Column {
                Row  (  modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(
                        text = "Tracking and Personalization for advertising",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start=10.dp)
                            .weight(0.8f),
                    )

                    Switch(
                        modifier = Modifier
                            .weight(0.2f),
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                    )

                }



            }
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp,)
        ) {
            Text(
                text = "Terms",
                fontWeight = FontWeight.Bold,
                color = ColorBlue
            )
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp,)
        ) {
            Text(
                text = "ACKNOWLEDGEMENTS",
                fontWeight = FontWeight.Bold,
                color = ColorBlue
            )
        }
    }
}