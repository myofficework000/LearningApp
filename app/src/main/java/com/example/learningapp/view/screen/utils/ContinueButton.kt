package com.example.learningapp.view.screen.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.learningapp.R
import com.example.learningapp.view.theme.Green40

@Composable
fun ContinueButton( onclick: () -> Unit, modifier: Modifier){
    Button(
        onClick = { onclick },
        colors = ButtonDefaults.buttonColors(Green40),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = stringResource(R.string.btn_continue))
    }
}