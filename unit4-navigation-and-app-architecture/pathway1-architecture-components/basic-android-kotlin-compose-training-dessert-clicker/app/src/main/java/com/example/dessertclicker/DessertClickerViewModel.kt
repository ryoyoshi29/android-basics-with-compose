package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DessertClickerUiState())
    val uiState: StateFlow<DessertClickerUiState> =  _uiState.asStateFlow()
    val desserts = Datasource.dessertList

    private fun determineDessertToShow(): Dessert {
        var dessertToShow = desserts.first()
        for(dessert in desserts) {
            if(_uiState.value.dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }
        return dessertToShow
    }
    fun updateRevenue() {
        _uiState.update { currentState ->
            val updatedRevenue = currentState.revenue.plus(currentState.currentDessertPrice)
            val updatedDessertsSold = currentState.dessertsSold.plus(1)
            currentState.copy(revenue = updatedRevenue, dessertsSold = updatedDessertsSold)
        }
    }

    fun showNextDessert() {
        val dessertToShow = determineDessertToShow()
        _uiState.update { currentState ->
            currentState.copy(
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price
            )
        }
    }
}