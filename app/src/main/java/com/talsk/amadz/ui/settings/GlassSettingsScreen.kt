import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassSettingsScreen() {
    // 1. यह यूज़र की चुनी हुई पारदर्शिता (Alpha) को सेव करेगा। 
    // शुरुआत में यह 0.15f (डिफ़ॉल्ट) पर रहेगा।
    var userAlpha by remember { mutableFloatStateOf(0.15f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        // 2. ग्लास वाला कार्ड जो यूज़र की सेटिंग के हिसाब से बदलेगा
        Box(
            modifier = Modifier
                .size(250.dp, 150.dp)
                // यहाँ हम यूज़र का चुना हुआ 'userAlpha' पास कर रहे हैं
                .realGlassModifier(glassAlpha = userAlpha)
        ) {
            Text(
                text = "Glass Card Demo",
                color = Color.Black, // अगर डार्क मोड हो तो White कर लेना
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // 3. पारदर्शिता कंट्रोल करने के लिए स्लाइडर (Slider)
        Text(text = "Transparency: ${(userAlpha * 100).toInt()}%")
        
        Slider(
            value = userAlpha,
            onValueChange = { newValue -> 
                userAlpha = newValue // जैसे ही यूज़र स्लाइड करेगा, कार्ड का लुक बदल जाएगा
            },
            valueRange = 0.0f..1.0f // 0.0 (पूरा गायब) से 1.0 (पूरा सफेद ठोस) तक
        )
    }
}

