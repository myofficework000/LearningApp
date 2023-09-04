package com.example.learningapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.modal.dto.User
import com.example.learningapp.modal.local.UserDao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInSignUpViewModel
    @Inject constructor(private val userDao: UserDao)
    : ViewModel() {



    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var firebaseUser: FirebaseUser

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
                    val user= User(firebaseUser.uid, email, password)
                    addIntoFireStoreDatabase(user)
                    checkAndAddIntoRoomLocalDatabase(user)
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

    private fun addIntoFireStoreDatabase(user: User) {
        val userRef = firebaseFirestore.collection(Companion.COLLECTION_USER).document(user.uid)
        userRef.set(user).addOnSuccessListener {
            _savedToFireStore.value = "User Successfully Saved to FirebaseStore"
        }.addOnFailureListener {
            _savedToFireStore.value = "User failed to Saved to FirebaseStore"
        }
    }
    fun checkAndAddIntoRoomLocalDatabase(user: User){
        var userFromDb= userDao.findUserById(user.uid)

        if(userFromDb == null){
            userDao.saveUser(user)
        }
        userFromDb= userDao.findUserById(user.uid)
        Log.i("SignInSignUpViewModel",
            userDao.getAllUser().toString())
    }
    fun checkAndAddIntoRoomLocalDatabase(user: FirebaseUser?){
        val email = user?.email ?: ""
        val uid = user?.uid ?: ""
        val phone = user?.phoneNumber ?: ""
        val imgUrl =user?.photoUrl ?: ""
        val userLocal= User(uid = uid,email=email,mobile =phone, imgURL = imgUrl.toString())
        checkAndAddIntoRoomLocalDatabase(userLocal)
    }
    private fun signInWithGoogle(){

    }

    companion object {
        private const val COLLECTION_USER = "users"
    }
}