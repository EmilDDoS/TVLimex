package com.example.tvlimex.data.network

import com.example.tvlimex.data.entity.TvDto
import retrofit2.http.GET

private const val END_POINT = "channels.json"

interface TvApiService {
    @GET(END_POINT)
    suspend fun getTvDto(): TvDto
}