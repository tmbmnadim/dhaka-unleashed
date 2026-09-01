package me.tmbmnadim.dhaka_unleashed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.tmbmnadim.dhaka_unleashed.ui.theme.Dhaka_unleashedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dhaka_unleashedTheme {
                DhakaUnleashedApp()
            }
        }
    }
}