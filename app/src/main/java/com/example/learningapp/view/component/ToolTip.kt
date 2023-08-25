package com.example.learningapp.view.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Preview
@Composable
fun TooltipPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hover over me!")

        ShowTooltip(
            text = "This is a tooltip",
            anchorAlignment = Alignment.TopCenter
        ) {
            Text("Hover over the tooltip anchor")
        }
    }
}

@Composable
fun ShowTooltip(
    text: String,
    anchorAlignment: Alignment,
    tooltipContent: @Composable () -> Unit
) {
    val isVisible = remember { mutableStateOf(true) }
    val tooltipWidth by animateDpAsState(if (isVisible.value) 200.dp else 0.dp, label = "")

    val arrowAlignment = when (anchorAlignment) {
        Alignment.TopStart, Alignment.TopCenter, Alignment.TopEnd ->
            Alignment.BottomCenter

        Alignment.BottomStart, Alignment.BottomCenter, Alignment.BottomEnd ->
            Alignment.TopCenter

        else -> Alignment.CenterStart
    }

    val tooltip = @Composable {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.surface)
                .width(tooltipWidth)
                .then(
                    Modifier.graphicsLayer(
                        shape = RoundedCornerShape(4.dp),
                        shadowElevation = 4f
                    )
                )
        ) {
            TooltipWindow(anchorAlignment, arrowAlignment, text, tooltipContent)
        }
    }

    Popup(
        properties = PopupProperties(focusable = false),
        alignment = Alignment.TopStart
    ) {
        tooltip()
    }
}

@Composable
private fun TooltipWindow(
    anchorAlignment: Alignment,
    arrowAlignment: Alignment,
    text: String,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .offset(y = if (arrowAlignment == Alignment.TopCenter) 8.dp else (-8).dp)
    ) {
        TooltipArrow()
    }
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text)
        Spacer(modifier = Modifier.height(4.dp))
        content()
    }
}
@Composable
private fun TooltipArrow() {
    val arrowColor = MaterialTheme.colorScheme.surface
    val arrowSize = 16.dp
    val arrowHeight = 8.dp
    val arrowWidth = (arrowSize * 2f / 3f)

    Box(
        modifier = Modifier
            .size(arrowWidth, arrowHeight)
            .background(arrowColor)
    )
}


