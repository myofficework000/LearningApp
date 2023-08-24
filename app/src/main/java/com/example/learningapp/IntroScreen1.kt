package com.example.learningapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.ui.theme.Green40
import com.example.learningapp.ui.theme.grey

@Preview(showBackground = true)
@Composable
fun IntroScreen(){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {


        val guideline = createGuidelineFromTop(0.2f)

        val(imageView, textDesc,buttonStarted, buttonOutline) = createRefs()

        Image(painter = painterResource(id = R.drawable.img), contentDescription ="nothing",
            modifier = Modifier.constrainAs(imageView){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(guideline)
            }, contentScale = ContentScale.Fit )

        Text(text = stringResource(id = R.string.text),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .constrainAs(textDesc) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageView.bottom)
                })

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonStarted) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonOutline.top)
                }
                .padding(horizontal = 16.dp)) {
            Text("GET STARTED",
                fontWeight = FontWeight.Bold ,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }

        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .constrainAs(buttonOutline) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ){
            Text("I ALREADY HAVE A ACCOUNT",
                color = Green40,
                fontWeight = FontWeight.Bold ,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp))
        }
    }

}