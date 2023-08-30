package com.example.learningapp.view.screen.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.learningapp.view.MainActivity
import com.example.learningapp.view.activity.DashboardActivity

fun showToast(context: Context, it: String) {
    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
}


fun moveToDashBoardScreen(context: Context) {
    context.startActivity(Intent(context, DashboardActivity::class.java))
}