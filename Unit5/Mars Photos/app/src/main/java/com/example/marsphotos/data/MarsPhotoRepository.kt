package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import com.example.marsphotos.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getPhotos() : List<MarsPhoto>
}

class NetworkMarsPhotosRepository(private val retrofitService: MarsApiService) : MarsPhotosRepository {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return retrofitService.getPhotos()
    }
}