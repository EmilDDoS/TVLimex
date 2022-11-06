package com.example.tvlimex.di

import com.example.tvlimex.data.LocalChannelsFlow
import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.network.TvApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://limehd.online/playlist/"

@Module
class DataModule {

    @Provides
    fun provideMapper() = Mapper

    @Provides
    fun provideLocalChannelsFlow() = LocalChannelsFlow

    @Singleton
    @Provides
    fun provideApi(): TvApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TvApiService::class.java)
    }
}


