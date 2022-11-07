package com.example.tvlimex.di

import android.content.Context
import androidx.room.Room
import com.example.tvlimex.data.LocalChannelsFlow
import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.db.AppDataBase
import com.example.tvlimex.data.network.TvApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://limehd.online/playlist/"
private const val NAME_DB = "minitv.db"

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

    @Provides
    fun provideDataBase(
        app: Context
    ): AppDataBase = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        NAME_DB
    )
        .build()
}


