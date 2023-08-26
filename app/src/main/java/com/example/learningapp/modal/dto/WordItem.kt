package com.example.learningapp.modal.dto

import androidx.compose.ui.graphics.Color

data class WordItem(val word: String, var isClicked: Boolean = false) {
    val placeholder: String
        get() = " ".repeat(word.length)
    val backgroundColor: Color
        get() = if (isClicked) Color.LightGray else Color.Transparent
}
