package com.example.learningapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.modal.dto.UserAddress
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class ProfileUpdateViewModal : ViewModel() {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseFirestore = FirebaseFirestore.getInstance()
    private val users = "users"
    private val userId = firebaseAuth.currentUser?.uid ?: "0"

    private val _savedToFireStore = MutableLiveData<String>()
    val savedToFireStore: LiveData<String> = _savedToFireStore

    fun saveUserAddress(address: UserAddress) {
        val userDocument = firebaseFirestore.collection(users).document(userId)
        userDocument.update("address", address)
            .addOnSuccessListener {
                _savedToFireStore.value = "Saved the address"
            }
    }

    fun updateUserAddress(address: UserAddress) {
        val userDocument = firebaseFirestore.collection(users).document(userId)
        userDocument.set(mapOf("address" to address), SetOptions.merge())
    }
}