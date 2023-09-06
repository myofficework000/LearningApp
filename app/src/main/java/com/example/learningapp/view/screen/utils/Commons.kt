package com.example.learningapp.view.screen.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import com.example.learningapp.view.activity.DashboardActivity

fun showToast(context: Context, it: String) {
    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
}


fun moveToDashBoardScreen(context: Context) {
    context.startActivity(Intent(context, DashboardActivity::class.java))
}

fun Context.getSharedPreferences(name:String="learningApp",mode:Int= MODE_PRIVATE): SharedPreferences {
    return getSharedPreferences(name, mode)
}

fun Context.getStringFromSharedPreferences(key: String):String{
    return getSharedPreferences().getString(key,"")?:""
}

fun Context.putStringInSharedPreferences(key:String,value:String){
    getSharedPreferences().edit().putString(key,value).apply()
}

fun Context.deleteSharedPref(){
    getSharedPreferences().edit().clear().apply()
}

