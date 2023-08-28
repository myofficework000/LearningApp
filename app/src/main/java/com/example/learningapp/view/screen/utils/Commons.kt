package com.example.learningapp.view.screen.utils

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, it: String) {
    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
}