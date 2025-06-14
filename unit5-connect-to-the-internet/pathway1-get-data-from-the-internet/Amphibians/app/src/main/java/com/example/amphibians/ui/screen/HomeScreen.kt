package com.example.amphibians.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amphibians.network.Amphibian

@Composable
fun HomeScreen(amphibiansUiState: AmphibiansUiState, modifier: Modifier) {
    when(amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen()
        is AmphibiansUiState.Success -> AmphibiansScreen(amphibiansUiState.amphibian)
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
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp)
    ) {

    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card {
        Text("Card")
    }
}

@Composable
fun ErrorScreen() {
    Text("Error")
}