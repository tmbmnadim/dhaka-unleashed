package me.tmbmnadim.dhaka_unleashed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.tmbmnadim.dhaka_unleashed.data.DhakaPlacesSource
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace
import me.tmbmnadim.dhaka_unleashed.ui.DhakaPlacesScreen
import me.tmbmnadim.dhaka_unleashed.ui.PlacesList

@Composable
fun DhakaUnleashedApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        DhakaPlacesScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun DhakaUnleashedAppPreview() {
    DhakaUnleashedApp()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DhakaUnleashedAppBar(title: String) {
    TopAppBar(

        title = {
            Text(title)
        }
    )
}