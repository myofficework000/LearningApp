package com.example.learningapp.modal.dto

import androidx.annotation.DrawableRes

data class Section(
    val title: String,
    val description: String,
    var currentUnit: Int,
    val maxUnit: Int,
    @DrawableRes val thumbnailImg:Int,
    var isUnlocked: Boolean = false
)
