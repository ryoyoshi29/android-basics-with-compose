package com.example.amphibians.data

import com.example.amphibians.network.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibianPhotos(): List<Amphibian>
}

class NetworkAmphibiansRepository: AmphibiansRepository {
    override suspend fun getAmphibianPhotos(): List<Amphibian> {
        return emptyList()
    }
}