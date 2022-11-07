package com.example.tvlimex.di

import com.example.tvlimex.data.LocalChannelsFlow
import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.RepositoryImpl
import com.example.tvlimex.data.db.AppDataBase
import com.example.tvlimex.data.network.TvApiService
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetChannelUseCase(
        repository: Repository
    ) = GetChannelsUseCase(repository)

    @Provides
    fun provideDbUseCase(
        repository: Repository
    ) = DbUseCase(repository)

    @Provides
    fun provideGetLocalChannelsUseCase(
        repository: Repository
    ) = GetLocalChannelsUseCase(repository)

    @Provides
    fun provideRepository(
        tvApiService: TvApiService,
        mapper: Mapper,
        localChannelsFlow: LocalChannelsFlow,
        appDataBase: AppDataBase
    ): Repository = RepositoryImpl(tvApiService, mapper, localChannelsFlow, appDataBase)
}