package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.R
import com.example.learningapp.view.screen.utils.OwlAnimation
import com.example.learningapp.view.theme.Green100

@Preview
@Composable
fun PathScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Green100),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    text = stringResource(R.string.unit_1))
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                    text = stringResource(R.string.form_basic_sentences))
            }
            Image(
                modifier = Modifier
                    .padding(20.dp)
                    .size(30.dp),
                painter = painterResource(id = R.drawable.ic_note_white),
                contentDescription = "notebook")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                modifier = Modifier
                    .offset(0.dp, 2.dp)
                    .padding(0.dp, 30.dp, 0.dp, 0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(2.dp, Color.LightGray)
            ) {
                Text(
                    color = Green100,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp),
                    text = stringResource(R.string.start))
            }
            Image(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 10.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_star_green),
                contentDescription = "star")

            Image(
                modifier = Modifier
                    .offset(-30.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_lock_grey),
                contentDescription = "lock")

            Row {
                Image(
                    modifier = Modifier
                        .offset(-20.dp, 0.dp)
                        .padding(20.dp)
                        .size(70.dp),
                    alignment = Alignment.CenterEnd,
                    painter = painterResource(id = R.drawable.ic_lock_grey),
                    contentDescription = "lock")
                OwlAnimation(
                    Modifier
                        .offset(50.dp, 0.dp)
                        .size(120.dp))
            }

            Image(
                modifier = Modifier
                    .offset(-30.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_treasure_grey),
                contentDescription = "treasure")

            Image(
                modifier = Modifier
                    .offset(30.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_lock_grey),
                contentDescription = "lock")

            Image(
                modifier = Modifier
                    .offset(60.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_lock_grey),
                contentDescription = "lock")

            Image(
                modifier = Modifier
                    .offset(90.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_lock_grey),
                contentDescription = "lock")

            Image(
                modifier = Modifier
                    .offset(60.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_treasure_grey),
                contentDescription = "treasure")

            Image(
                modifier = Modifier
                    .offset(30.dp, 0.dp)
                    .padding(20.dp)
                    .size(70.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_trophy_grey),
                contentDescription = "treasure")
        }
    }

}