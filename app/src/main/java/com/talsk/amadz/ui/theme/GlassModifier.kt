package com.talsk.amadz.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// यहाँ glassAlpha = 0.15f डिफ़ॉल्ट सेट है
fun Modifier.realGlassModifier(
    cornerRadius: Dp = 16.dp,
    blurRadius: Dp = 20.dp, 
    glassAlpha: Float = 0.15f // यह डिफ़ॉल्ट पारदर्शिता है
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        .blur(radius = blurRadius) 
        .background(Color.White.copy(alpha = glassAlpha)) // यहाँ अल्फा यूज़र की सेटिंग से बदलेगा
        .border(
            width = 1.5.dp, 
            color = Color.White.copy(alpha = 0.5f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
