package com.example.learningapp.modal.dto

import androidx.annotation.DrawableRes


data class DailyQuest(
    val title: String,
    val process: Int,
    val maxProcess: Int,
    @DrawableRes val thumbnailImg:Int,
)
