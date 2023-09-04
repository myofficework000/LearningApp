package com.example.learningapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.modal.dto.User
import com.example.learningapp.view.screen.utils.putStringInSharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class SignInSignUpViewModel : ViewModel() {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var firebaseUser: FirebaseUser
    private val users = "users"

    private val _registrationStatus = MutableLiveData<String>()
    val registrationStatus: LiveData<String> = _registrationStatus

    private val _registrationEmailStatus = MutableLiveData<String>()
    val registrationEmailStatus: LiveData<String> = _registrationEmailStatus

    private val _savedToFireStore = MutableLiveData<String>()
    val savedToFireStore: LiveData<String> = _savedToFireStore

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    fun registerUserUsingEmail(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _registrationStatus.value = "Register Successful!!"
                    firebaseUser = firebaseAuth.currentUser!!
                    sendVerificationEmailLink()
                    addIntoFireStoreDatabase(User(firebaseUser.uid, email, password))
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

    fun login(email: String, password: String,context: Context) {
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _loginStatus.value = "Login Success!!"
                    // Add to sharedPreference
                    context.putStringInSharedPreferences("email",email)
                    context.putStringInSharedPreferences("password",password)

                } else {
                    _loginStatus.value = "Login Failed!!"
                }
            }
    }

    private fun addIntoFireStoreDatabase(user: User) {
        val userRef = firebaseFirestore.collection(users).document(user.userId)
        userRef.set(user).addOnSuccessListener {
            _savedToFireStore.value = "User Successfully Saved to FirebaseStore"
        }.addOnFailureListener {
            _savedToFireStore.value = "User failed to Saved to FirebaseStore"
        }
    }
}