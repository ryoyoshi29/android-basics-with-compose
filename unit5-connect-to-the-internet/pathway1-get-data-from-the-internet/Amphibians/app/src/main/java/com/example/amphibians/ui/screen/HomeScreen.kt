package com.example.amphibians.ui.screen

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.amphibians.network.Amphibian
import java.nio.file.WatchEvent

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen()
        is AmphibiansUiState.Success -> AmphibiansScreen(
            amphibiansUiState.amphibian,
            modifier = modifier.padding(horizontal = 4.dp),
            contentPadding = contentPadding
        )

        is AmphibiansUiState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Text("Loading")
}

@Composable
fun AmphibiansScreen(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(400.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ) {
        items(items = amphibians) { amphibians ->
            AmphibianCard(
                amphibians,
                modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = amphibian.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(5.dp)
        )
        if (LocalInspectionMode.current) {
            // Preview時
            Image(
                painter = ColorPainter(color = Color.Gray),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        } else {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(
            text = amphibian.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.padding(5.dp)
        )
    }
}

@Composable
fun ErrorScreen() {
    Text("Error")
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(
        amphibiansUiState = AmphibiansUiState.Success(
            listOf(
                Amphibian(
                    name = "Great Basin Spadefoot",
                    type = "Toad",
                    description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
                    imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
                ),
                Amphibian(
                    name = "Great Basin Spadefoot",
                    type = "Toad",
                    description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
                    imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
                ),
                Amphibian(
                    name = "Great Basin Spadefoot",
                    type = "Toad",
                    description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
                    imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
                ),
                Amphibian(
                    name = "Great Basin Spadefoot",
                    type = "Toad",
                    description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
                    imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
                )
            )
        ),
        modifier = Modifier,
        contentPadding = PaddingValues(0.dp)
    )
}