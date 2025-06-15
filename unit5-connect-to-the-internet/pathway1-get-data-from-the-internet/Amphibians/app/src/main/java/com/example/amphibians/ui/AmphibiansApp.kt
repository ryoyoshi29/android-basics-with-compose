package com.example.amphibians.ui

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screen.AmphibiansViewModel
import com.example.amphibians.ui.screen.HomeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { AmphibiansTopBar(scrollBehavior) }
    ) {
        val amphibiansViewModel: AmphibiansViewModel = viewModel()
        HomeScreen(
            amphibiansViewModel.amphibiansUiState,
            modifier = Modifier,
            contentPadding = it
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansTopBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(stringResource(R.string.app_name)) }
    )
}

@Preview
@Composable
fun AmphibiansAppPreview() {
    AmphibiansApp()
}