package com.example.learningapp.view.component

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
/*

@Composable
fun SelectorButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: androidx.compose.ui.graphics.Shape = CircleShape,
    defaultColor: Color = Color.Gray,
    pressedColor: Color = Color.Blue,
    shadowColor: Color = Color.Black, // Customize the shadow color
    shadowElevation: Dp = 4.dp, // Customize the shadow elevation
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    val backgroundColor = if (isPressed) pressedColor else defaultColor

    Box(
        modifier = modifier
            .background(backgroundColor, shape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    isPressed = true
                    onClick()
                }
            )
            .padding(bottom = shadowElevation) // Add padding for shadow
            .zIndex(if (isPressed) 0f else 1f) // Change the Z index for shadow
    ) {
        content()
        if (!isPressed) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                shadowColor.copy(alpha = 0.5f),
                                shadowColor.copy(alpha = 0.0f)
                            ),
                            startY = 0f,
                            endY = shadowElevation.toPx()
                        )
                    )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSelectorButton() {
    SelectorButton()
}
*/
