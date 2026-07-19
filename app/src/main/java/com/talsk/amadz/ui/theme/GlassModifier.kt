package com.talsk.amadz.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

fun Modifier.realGlassModifier(
    hazeState: HazeState? = null,
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        // 👇 यहाँ shape जोड़ दिया गया है जिससे क्रैश के चांस 0% हो जाएँगे
        .then(
            if (hazeState != null) Modifier.hazeChild(state = hazeState, shape = RoundedCornerShape(cornerRadius))
            else Modifier
        )
        .background(Color.White.copy(alpha = glassAlpha))
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.4f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
