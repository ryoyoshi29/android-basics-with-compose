package com.example.amphibians.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.size.Scale
import com.example.amphibians.ui.screen.AmphibiansViewModel
import com.example.amphibians.ui.screen.HomeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AmphibiansApp() {
    Scaffold(modifier = Modifier) {
        Surface(modifier = Modifier.fillMaxSize()) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel()
            HomeScreen(
                amphibiansViewModel.amphibiansUiState,
                modifier = Modifier
            )
        }
    }
}