package com.example.learningapp.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.modal.dto.SelectImage
import com.example.learningapp.view.theme.GreyWhite
import com.example.learningapp.view.theme.LightGrey
import com.example.learningapp.view.theme.lightBlack
import com.example.learningapp.view.theme.purple



@Composable
fun SelectCorrectImage(navController : NavController){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val(listView,textNewWord, textCorrectImage, textHombre, btnCheck,soundImage) = createRefs()

        Text(text = stringResource(id = R.string.new_word),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = purple,
            modifier = Modifier
                .constrainAs(textNewWord) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .padding(start = 28.dp, top = 24.dp, end = 8.dp))

        Text(text = stringResource(id = R.string.select_correct_image),
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .constrainAs(textCorrectImage) {
                    start.linkTo(parent.start)
                    top.linkTo(textNewWord.bottom)
                }.padding(start = 16.dp, top = 16.dp,))

        Image(painter = painterResource(id = R.drawable.sound),
            contentDescription = " Img ",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 8.dp)
                .height(80.dp)
                .width(80.dp)
                .constrainAs(soundImage) { start.linkTo(parent.start)
                    top.linkTo(textCorrectImage.bottom)
                }.padding(start = 16.dp))

        Text(text = stringResource(id = R.string.TEXT_EL_HOMRE),
            color = purple,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .constrainAs(textHombre) {
                    start.linkTo(soundImage.end)
                    top.linkTo(textCorrectImage.bottom)
                }.padding(start = 8.dp, top = 30.dp,))

        LazyVerticalGrid(GridCells.Fixed(2 ),
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(listView){
                start.linkTo(parent.start)
                top.linkTo(soundImage.bottom)
                end.linkTo(parent.end)
            }
            ){
            items(imagesList()){selectImage->
                SelectImage(selectImage)

            }
        }


        Button(onClick = { },
            colors = ButtonDefaults.buttonColors(GreyWhite),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(btnCheck) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(horizontal = 16.dp, vertical = 16.dp)) {
            Text(
                text = stringResource(id = R.string.BUTTON_CHECK_CAPS),
                color = LightGrey,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }

}


@Composable
fun SelectImage(selectImage: SelectImage){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp,GreyWhite),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (image, name) = createRefs()

            Image(painter = painterResource(id = selectImage.image),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(150.dp)
                    .width(150.dp)
                    .constrainAs(image) { start.linkTo(parent.start)
                    end.linkTo(parent.end)})

            Spacer(modifier = Modifier.size(10.dp))

            Text(text =selectImage.name ,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(name) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

        }
    }
}

fun imagesList() = listOf(
    SelectImage(R.drawable.boy, "the boy"),
    SelectImage(R.drawable.girl,"the girl"),
    SelectImage(R.drawable.women,"the women"),
    SelectImage(R.drawable.man,"the man"),
)