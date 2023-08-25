package com.example.learningapp.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningapp.R
import com.example.learningapp.ui.theme.Green40


@Preview
@Composable
fun FreshStartScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()) {
        val (containerOwl,  btnContinue) = createRefs()
        ContainerOwlAnimationWithText(
            text= stringResource(R.string.start_fresh),
            modifier = Modifier.constrainAs(containerOwl){
            top.linkTo(parent.top)
        })

        Button(
            onClick = {        },
            colors= ButtonDefaults.buttonColors(Green40),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .constrainAs(btnContinue) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(R.string.btn_continue),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}
