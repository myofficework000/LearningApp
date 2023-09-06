package com.example.learningapp.modal.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learningapp.modal.local.DatabaseConstant.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class User(
    @PrimaryKey val uid: String = "",
    val email: String = "",
    val password: String = "",
    val mobile : String ="",
    val imgURL : String =""
)
