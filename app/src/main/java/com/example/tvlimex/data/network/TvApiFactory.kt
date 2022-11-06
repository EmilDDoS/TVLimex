package com.example.tvlimex.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://limehd.online/playlist/"

object TvApiFactory {
    val instance: TvApi
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TvApi::class.java)
}
