package com.talsk.amadz.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
// 👇 Haze के नए इम्पोर्ट
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

fun Modifier.realGlassModifier(
    hazeState: HazeState, // 👈 यह कनेक्शन है जो बैकग्राउंड और बटन को जोड़ेगा
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        // 👇 असली जादू: यह टेक्स्ट को छोड़ेगा और सिर्फ पीछे की चीज़ों को ब्लर करेगा
        .hazeChild(state = hazeState) 
        .background(Color.White.copy(alpha = glassAlpha))
        .border(
            width = 1.dp, // थोड़ा पतला बॉर्डर iPhone जैसा लगता है
            color = Color.White.copy(alpha = 0.4f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
