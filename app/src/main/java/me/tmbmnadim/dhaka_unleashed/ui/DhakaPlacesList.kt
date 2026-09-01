package me.tmbmnadim.dhaka_unleashed.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.tmbmnadim.dhaka_unleashed.ui.theme.Dhaka_unleashedTheme


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dhaka_unleashedTheme {
        Greeting("Android")
    }
}