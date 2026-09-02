package me.tmbmnadim.dhaka_unleashed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import me.tmbmnadim.dhaka_unleashed.ui.theme.Dhaka_unleashedTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSize = calculateWindowSizeClass(
                activity = this
            )
            Dhaka_unleashedTheme {
                DhakaUnleashedApp(windowSize.widthSizeClass)
            }
        }
    }
}