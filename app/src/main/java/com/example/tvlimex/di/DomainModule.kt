package com.example.tvlimex.di

import com.example.tvlimex.data.LocalChannelsFlow
import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.RepositoryImpl
import com.example.tvlimex.data.network.TvApiFactory
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    fun provideGetChannelUseCase(
        repository: Repository
    ) = GetChannelsUseCase(repository)

    @Provides
    fun provideGetLocalChannelsUseCase(
        repository: Repository
    ) = GetLocalChannelsUseCase(repository)

    @Provides
    fun provideRepository(
        tvApiFactory: TvApiFactory,
        mapper: Mapper,
        localChannelsFlow: LocalChannelsFlow
    ): Repository = RepositoryImpl(tvApiFactory, mapper, localChannelsFlow)
}