package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.modal.dto.SearchFriendMethod
import com.example.learningapp.view.theme.GreyWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SearchFriendScreen() {

    val methods = listOf(
        SearchFriendMethod("Find contacts","Find your friends on Duolingo",R.drawable.blog),
        SearchFriendMethod("Connect to Facebook","See who you know on Duolingo",R.drawable.facebook),
        SearchFriendMethod("Invite friends","Learn together with friends",R.drawable.ic_mail)
    )

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (staticTextSearchFriend, searchBar, networkCardView) = createRefs()
        var keyWordFriend by remember { mutableStateOf("") }
        Text(
            text = "Search for friends",
            fontSize = 20.sp,
            color = Color.Gray,
            modifier = Modifier
                .constrainAs(staticTextSearchFriend) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        OutlinedTextField(
            value = keyWordFriend,
            shape = RoundedCornerShape(12.dp),
            onValueChange = { keyWordFriend = it },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(searchBar) {
                    top.linkTo(staticTextSearchFriend.bottom, 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = Color.Gray,
                focusedBorderColor = Color.Gray
            ),
            placeholder = { Text("Email, name or username") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(networkCardView) {
                    top.linkTo(searchBar.bottom, 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            methods.forEach {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray
                        )
                ) {
                    Image(
                        painter = painterResource(it.image),
                        contentDescription = "contact",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp),
                        alignment = Alignment.TopStart
                    )
                    Column {
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = it.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(4.dp)
                        )
                        Text(
                            text = it.description,
                            modifier = Modifier.padding(4.dp)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(
                            imageVector = Icons.Default.NavigateNext,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}