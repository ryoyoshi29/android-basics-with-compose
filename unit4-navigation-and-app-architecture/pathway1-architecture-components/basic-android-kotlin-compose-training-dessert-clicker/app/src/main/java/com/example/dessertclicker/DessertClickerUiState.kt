package com.example.dessertclicker

import com.example.dessertclicker.data.Datasource

data class DessertClickerUiState (
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[0].price,
    val currentDessertImageId: Int = Datasource.dessertList[0].imageId
)