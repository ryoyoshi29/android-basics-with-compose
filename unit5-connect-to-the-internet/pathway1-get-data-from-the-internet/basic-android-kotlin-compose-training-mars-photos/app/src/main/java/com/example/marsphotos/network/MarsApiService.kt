package com.example.marsphotos.network

import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhoto(): List<MarsPhoto>
}