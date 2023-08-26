package com.example.learningapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
class SignInSignUpViewModel : ViewModel() {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var firebaseUser: FirebaseUser

    private val _registrationStatus = MutableLiveData<String>()
    val registrationStatus: LiveData<String> = _registrationStatus

    private val _registrationEmailStatus = MutableLiveData<String>()
    val registrationEmailStatus: LiveData<String> = _registrationEmailStatus

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    fun registerUserUsingEmail(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _registrationStatus.value = "Register Successful!!"
                    firebaseUser = firebaseAuth.currentUser!!
                    sendVerificationEmailLink()
                } else {
                    _registrationStatus.value = "Register failed"
                }
            }
    }

    private fun sendVerificationEmailLink() {
        if (this::firebaseUser.isInitialized) {
            firebaseUser.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _registrationEmailStatus.value = "Registration email sent"
                } else {
                    _registrationEmailStatus.value = "Failed to send registration email"
                }
            }
        }
    }

    fun login(email: String, password: String) {
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _loginStatus.value = "Login Success!!"
                } else {
                    _loginStatus.value = "Login Failed!!"
                }
            }
    }
}