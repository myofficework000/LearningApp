package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Gender
import com.example.learningapp.modal.dto.GenderData
import com.example.learningapp.view.theme.Blue100

@Preview(showBackground = true)
@Composable
fun GenderScreen(){
    val genderData: GenderData = GenderData(
        header = "Gender",
        body1Text = "In Spanish, all nouns are either masculine or faminine. Often, nouns end in -o if they are masculine and -a if they are faminine.",
        body2Text = "Notice how you use elif the word is masculine and la if the word is faminine.",
        list = listOf(
            Gender("el nino", "The boy", R.drawable.boy),
            Gender("la nina", "The girl", R.drawable.girl)
        )
    )

    Surface(
        color = Blue100.copy(alpha = 0.2F)
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 16.dp)
        ) {
            Text(
                text = "TIP", color = Blue100,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = genderData.header, color = Color.Black,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = genderData.body1Text, color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )

            Box(
                modifier = Modifier.padding(top = 24.dp)
            )
            {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    genderData.list.forEach{
                        GenderCard(gender = it)
                    }
                }
            }
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = genderData.body2Text, color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun GenderCard(modifier: Modifier = Modifier, gender: Gender){
    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Blue100.copy(alpha = 0.4F)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .weight(0.1F)
                    .padding(top = 16.dp),
                painter = painterResource(id = R.drawable.ic_audio), contentDescription = null)
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(0.3F),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text =gender.text, color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = gender.gender,color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Image(
                modifier = Modifier
                    .size(100.dp)
                    .weight(0.6F),
                alignment = Alignment.BottomEnd,
                painter = painterResource(id = gender.image), contentDescription = null,
            )

        }
    }

}
