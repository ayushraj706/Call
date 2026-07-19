package com.talsk.amadz.ui.settings

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.talsk.amadz.ui.theme.realGlassModifier

@Composable
fun GlassSettingsScreen() {
    val context = LocalContext.current
    
    // 1. फोन की मेमोरी (SharedPreferences) को चालू करना
    val sharedPreferences = remember {
        context.getSharedPreferences("GlassThemePrefs", Context.MODE_PRIVATE)
    }

    // 2. सेव की हुई वैल्यू को निकालना (डिफ़ॉल्ट 0.15f)
    var userAlpha by remember { 
        mutableFloatStateOf(sharedPreferences.getFloat("glass_alpha", 0.15f)) 
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        // 3. ग्लास वाला कार्ड जो सेटिंग के हिसाब से बदलेगा
        Box(
            modifier = Modifier
                .size(250.dp, 150.dp)
                .realGlassModifier(glassAlpha = userAlpha)
        ) {
            Text(
                text = "Glass Card Demo",
                color = Color.White, 
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Transparency: ${(userAlpha * 100).toInt()}%", 
            color = Color.White
        )
        
        Slider(
            value = userAlpha,
            onValueChange = { newValue -> 
                userAlpha = newValue 
                // 4. स्लाइडर हिलते ही नई वैल्यू मेमोरी में सेव हो जाएगी
                sharedPreferences.edit().putFloat("glass_alpha", newValue).apply()
            },
            valueRange = 0.0f..1.0f 
        )
    }
}
