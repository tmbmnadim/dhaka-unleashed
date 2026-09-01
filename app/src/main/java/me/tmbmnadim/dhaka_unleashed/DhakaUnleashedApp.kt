package me.tmbmnadim.dhaka_unleashed

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tmbmnadim.dhaka_unleashed.ui.Greeting
import java.time.format.TextStyle

@Composable
fun DhakaUnleashedApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DhakaUnleashedAppPreview() {
    PlacesList()
}

@Composable
fun PlacesList() {
    LazyColumn() {
        item {
            PlacesListItem(
                image = R.drawable.ahsan_monjil,
                title = "Title",
                subtitle = "Sub title"
            )
        }
    }
}

@Composable
fun PlacesListItem(
    @DrawableRes image: Int,
    title: String,
    subtitle: String,
) {
    Card(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp, 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier.size(42.dp)
            )
            Box(modifier = Modifier.width(8.dp))
            Column() {
                Text(
                    title,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    subtitle,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }

    }
}