package com.example.learningapp.modal.dto

import androidx.annotation.DrawableRes

data class SearchFriendMethod(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)
