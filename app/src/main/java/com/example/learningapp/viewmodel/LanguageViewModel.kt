package com.example.learningapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Locale

class LanguageViewModel : ViewModel() {
    private val supportedLanguages = listOf(
        "en", // English
        "fr", // French
        "es", // Spanish
        "de", // German
        "it", // Italian
        "pt", // Portuguese
        "ja", // Japanese
        "ko", // Korean
        "zh", // Chinese
        "ru", // Russian
        "ar", // Arabic
        "hi"  //Hindi
    )

    private val defaultLanguage = "en"
    private val _currentLanguage = mutableStateOf(defaultLanguage)
    val currentLanguage = _currentLanguage

    fun setLanguage(languageCode: String) {
        if (supportedLanguages.contains(languageCode)) {
            _currentLanguage.value = languageCode
            updateLocale(languageCode)
        }
    }

    private fun updateLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
    }
}
