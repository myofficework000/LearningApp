package com.example.learningapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.learningapp.view.navigation.MyApp
import com.example.learningapp.view.screen.utils.moveToDashBoardScreen
import com.example.learningapp.view.theme.LearningAppTheme
import com.example.learningapp.viewmodel.SignInSignUpViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signInSignUpViewModel: SignInSignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (FirebaseAuth.getInstance().currentUser != null) {
                        Log.i("MainActivity",
                            FirebaseAuth.getInstance().currentUser?.phoneNumber.toString())
                        moveToDashBoardScreen(this)
                    } else {

                        MyApp()
                    }
                }
            }
        }
    }
}
