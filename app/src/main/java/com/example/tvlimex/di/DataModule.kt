package com.example.tvlimex.di

import com.example.tvlimex.data.LocalChannelsFlow
import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.network.TvApiFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApi() = TvApiFactory

    @Provides
    fun provideMapper() = Mapper

    @Provides
    fun provideLocalChannelsFlow() = LocalChannelsFlow
}