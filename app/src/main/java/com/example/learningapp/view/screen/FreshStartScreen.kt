package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.learningapp.R
import com.example.learningapp.view.navigation.NavRoutes.LEARNING_REASON_SCREEN
import com.example.learningapp.view.screen.utils.OwlAnimationWithTextOnLeft
import com.example.learningapp.view.theme.Green40

@Composable
fun FreshStartScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()) {
        val (containerOwl,  btnContinue) = createRefs()
        OwlAnimationWithTextOnLeft(
            text= stringResource(R.string.start_fresh),
            modifier = Modifier.constrainAs(containerOwl){
            top.linkTo(parent.top)
        })

        Button(
            onClick = {   navController.navigate(LEARNING_REASON_SCREEN)     },
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
