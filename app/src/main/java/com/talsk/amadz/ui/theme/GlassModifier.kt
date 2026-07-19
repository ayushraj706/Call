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

// 1. पुरानी स्क्रीन्स के लिए (बिना Haze के) - इससे तुम्हारा एरर 100% ठीक हो जाएगा
fun Modifier.realGlassModifier(
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        .background(Color.White.copy(alpha = glassAlpha))
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.4f),
            shape = RoundedCornerShape(cornerRadius)
        )
}

// 2. डायलर और नई स्क्रीन्स के लिए (Haze बैकग्राउंड ब्लर के साथ)
fun Modifier.realGlassModifier(
    hazeState: HazeState, // यहाँ HazeState ज़रूरी है
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        .hazeChild(state = hazeState) 
        .background(Color.White.copy(alpha = glassAlpha))
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.4f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
