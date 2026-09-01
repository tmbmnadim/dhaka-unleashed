package me.tmbmnadim.dhaka_unleashed.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tmbmnadim.dhaka_unleashed.DhakaUnleashedAppBar
import me.tmbmnadim.dhaka_unleashed.data.DhakaPlacesSource
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace
import me.tmbmnadim.dhaka_unleashed.ui.theme.Dhaka_unleashedTheme

@Composable
fun DhakaPlacesScreen(modifier: Modifier = Modifier) {
    val places: List<DhakaPlace> = DhakaPlacesSource.places
    Column(
        modifier = modifier
    ) {
        DhakaUnleashedAppBar()
        PlacesList(
            places = places, modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun PlacesList(places: List<DhakaPlace>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(places) { place ->
            PlacesListItem(
                image = place.image,
                title = place.title,
                subtitle = place.subtitle
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
            .padding(vertical = 4.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp, 16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.width(8.dp))
            Column() {
                Text(
                    title,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    subtitle,
                    maxLines = 1,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }

    }
}