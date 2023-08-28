package com.example.learningapp.view.component

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable
fun ToolBarWithProgressBar(
    progress: Int,
    title: String
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = {
                if (onBackPressedDispatcher != null) {
                    if (!onBackPressedDispatcher.hasEnabledCallbacks()) {
                        // Handle navigation when there are no back callbacks in the stack
                        // This is effectively similar to the back navigation gesture
                        // You can customize this behavior based on your needs
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
            AnimatedProgressBar(progress)
        }
    )
}