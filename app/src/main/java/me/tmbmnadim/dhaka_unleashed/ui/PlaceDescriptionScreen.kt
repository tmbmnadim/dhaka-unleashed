package me.tmbmnadim.dhaka_unleashed.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tmbmnadim.dhaka_unleashed.data.DhakaPlacesSource
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace
import me.tmbmnadim.dhaka_unleashed.utils.DhakaUnleashContentType

@Composable
fun PlacesDescriptionScreen(
    place: DhakaPlace?,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
) {
    BackHandler{
        onBackPressed()
    }
    place?.let {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(it.image),
                contentDescription = "",
                modifier = Modifier
                    .height(250.dp)
                    .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    it.title,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    it.subtitle,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    it.description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesDescriptionScreenPreview() {
    val place:DhakaPlace = DhakaPlacesSource.places.first()
    PlacesDescriptionScreen(place)
}