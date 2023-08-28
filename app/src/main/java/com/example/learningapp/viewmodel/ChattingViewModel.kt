package com.example.learningapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.modal.dto.Message
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random

class ChattingViewModel : ViewModel() {

    private var firebaseDatabase = FirebaseDatabase.getInstance()
    private val chat = "chat"
    private val messageRef: DatabaseReference = firebaseDatabase.getReference(chat)

    private val _messageList = MutableLiveData<List<Message>>()
    val messageList: LiveData<List<Message>> = _messageList

    fun sendMessage(messageText: String) {
        val message = Message(messageText, Random.nextBoolean())
        messageRef.push().setValue(message)
            .addOnSuccessListener {
                fetchUserMessages()
                Log.i("tag", "Success added a message")
            }
            .addOnFailureListener {
                Log.i("tag", "Failed to add a message")
            }
    }

  private fun fetchUserMessages() {
        messageRef.addValueEventListener(
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val newMessages = mutableListOf<Message>()

                for (snapShot in snapshot.children) {
                    val message = snapShot.getValue(Message::class.java)
                    message.let { newMessages.add(it!!) }
                }
                _messageList.value = newMessages
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("tag", error.message)
            }
        })
    }
}