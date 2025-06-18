package com.example.amphibians.network

import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("Amphibians")
    fun getAmphibians(): List<Amphibian>
}