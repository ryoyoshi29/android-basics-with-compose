package com.example.amphibians.data

import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibianPhotos(): List<Amphibian>
}

class NetworkAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository {
    override suspend fun getAmphibianPhotos(): List<Amphibian> {
        return amphibiansApiService.getAmphibians()
    }
}