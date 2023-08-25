package com.example.learningapp.modal.dto

import com.example.learningapp.R

data class Achievement(val title: String, val subtitle: String, val img: Int)

fun getAchievements() = listOf(
    Achievement(
        "Converse with confidence",
        "60,200+ stress-free interactive exercises",
        R.drawable.ic_messages
    ),
    Achievement(
        "Build a large vocabulary",
        "8,400+practical words and Phrased",
        R.drawable.ic_flash_cards
    ),
    Achievement(
        "Develop a learning habit",
        "Smart reminders, fun challenges, and more",
        R.drawable.ic_watch
    )
)