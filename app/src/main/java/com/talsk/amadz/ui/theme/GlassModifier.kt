package com.talsk.amadz.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// अपडेटेड कोड: यहाँ से blur हटा दिया गया है
fun Modifier.realGlassModifier(
    cornerRadius: Dp = 16.dp,
    glassAlpha: Float = 0.15f // यह डिफ़ॉल्ट पारदर्शिता है
): Modifier {
    return this
        .clip(RoundedCornerShape(cornerRadius))
        // बैकग्राउंड को पारदर्शी सफेद करेगा
        .background(Color.White.copy(alpha = glassAlpha)) 
        .border(
            width = 1.5.dp, // चमकता हुआ सफेद बॉर्डर
            color = Color.White.copy(alpha = 0.5f),
            shape = RoundedCornerShape(cornerRadius)
        )
}
