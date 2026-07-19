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
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f,
    hazeState: HazeState? = null // 👈 इसे Optional (null) बना दिया है
): Modifier {
    // 1. बेस मॉडिफायर तैयार करो
    var modifier = this.clip(RoundedCornerShape(cornerRadius))
    
    // 2. असली जादू: अगर किसी फाइल ने hazeState भेजा है, तभी Haze ब्लर लगाओ
    if (hazeState != null) {
        modifier = modifier.hazeChild(state = hazeState)
    }
    
    // 3. बाकी का ग्लास इफ़ेक्ट (सफेद पारदर्शी रंग और बॉर्डर) लगाओ
    return modifier
        .background(Color.White.copy(alpha = glassAlpha))
        .border(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.4f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
