package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.learningapp.view.screen.utils.ContinueButton
import com.example.learningapp.view.screen.utils.OwlAnimation

@Composable
fun PracticeLaterScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (practiceText, animation, continueButton) = createRefs()

        Text(
            text = "Don't worry! We'll practice those concepts later.",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
                .constrainAs(
                    practiceText
                ) {
                    bottom.linkTo(animation.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                })
        OwlAnimation(modifier = Modifier.constrainAs(animation) {
            bottom.linkTo(continueButton.top, 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        ContinueButton(onclick = { }, modifier = Modifier.constrainAs(continueButton) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

    }


}
