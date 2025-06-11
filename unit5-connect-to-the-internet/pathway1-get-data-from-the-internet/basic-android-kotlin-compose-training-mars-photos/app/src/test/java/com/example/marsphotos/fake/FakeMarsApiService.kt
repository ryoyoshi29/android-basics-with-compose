package com.example.marsphotos.fake

import com.example.marsphotos.network.MarsApiService
import com.example.marsphotos.network.MarsPhoto

class FakeMarsApiService: MarsApiService {
    override suspend fun getPhoto(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}