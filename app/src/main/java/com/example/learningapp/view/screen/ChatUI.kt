package com.example.learningapp.view.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.modal.dto.Message
import com.example.learningapp.view.theme.Blue100
import com.example.learningapp.viewmodel.ChattingViewModel
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun DemoChatScreen(){

    ChatScreen(navController = rememberNavController())
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatScreen(navController: NavController) {
    var newMessage by remember { mutableStateOf("") }
    val chattingViewModel: ChattingViewModel = viewModel()
    val messages = chattingViewModel.messageList.observeAsState()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (chatList, inputContainer) = createRefs()
        // Display messages
        messages.value?.let {
            if (it.isNotEmpty()) {
                MessageList(
                    messages = it,
                    modifier=
                        Modifier.fillMaxSize()
                            .constrainAs(chatList){
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(inputContainer.top)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            })
            }
        }

        // Input field for sending messages
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .constrainAs(inputContainer){
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Blue100
                ),
                value = newMessage,
                onValueChange = { newMessage = it },
                label = { Text("Message") },
                modifier = Modifier
                    .wrapContentWidth(),
                maxLines = 1,
                singleLine = true
            )

            Button(
                onClick = {
                    chattingViewModel.sendMessage(newMessage)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(text = "Send")
            }
        }
    }
}

@Composable
fun MessageList(messages: List<Message>, modifier : Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(messages){ message ->
            MessageItem(message = message)
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        contentAlignment = if (message.sentByCurrentUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Text(
            text = message.text,
            color = Color.Black,
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Gray, MaterialTheme.shapes.medium)
                .padding(8.dp)
        )
    }
}


