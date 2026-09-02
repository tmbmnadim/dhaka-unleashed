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
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tmbmnadim.dhaka_unleashed.DhakaUnleashedApp
import me.tmbmnadim.dhaka_unleashed.DhakaUnleashedAppBar
import me.tmbmnadim.dhaka_unleashed.data.DhakaPlacesSource
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace

@Composable
fun DhakaPlacesScreen(
    modifier: Modifier = Modifier,
    places: List<DhakaPlace>,
    selectedPlace: DhakaPlace,
    showSelection: Boolean = false,
    onTap: (DhakaPlace) -> Unit = {}
) {
    PlacesList(
        places = places,
        modifier = modifier
            .padding(horizontal = 16.dp),
        selectedPlace = selectedPlace,
        showSelection = showSelection,
        onTap = onTap
    )
}

@Preview(showBackground = true)
@Composable
fun DhakaPlacesScreenPreview() {
    DhakaPlacesScreen(
        places = DhakaPlacesSource.places,
        selectedPlace = DhakaPlacesSource.places[0],
    )
}

@Composable
fun PlacesList(
    places: List<DhakaPlace>,
    selectedPlace: DhakaPlace,
    modifier: Modifier = Modifier,
    showSelection: Boolean = false,
    onTap: (DhakaPlace) -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        items(places) { place ->
            PlacesListItem(
                image = place.image,
                title = place.title,
                subtitle = place.subtitle,
                showSelection = showSelection,
                isSelected = selectedPlace.id == place.id,
                onTap = {
                    onTap(place)
                }
            )
        }
    }
}

@Composable
fun PlacesListItem(
    @DrawableRes image: Int,
    title: String,
    subtitle: String,
    showSelection: Boolean = false,
    isSelected: Boolean = false,
    onTap: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp),
        colors = if(isSelected && showSelection){
            CardDefaults.cardColors(
                containerColor = Color(0x00000000)
            )
        } else {
            CardDefaults.cardColors(
                containerColor = Color(0xF0F0F0F0)
            )
        },
        onClick = onTap
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
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    subtitle,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }

    }
}