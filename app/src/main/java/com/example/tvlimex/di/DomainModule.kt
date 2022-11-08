package com.example.tvlimex.di

import com.example.tvlimex.data.Mapper
import com.example.tvlimex.data.RepositoryImpl
import com.example.tvlimex.data.db.AppDataBase
import com.example.tvlimex.data.network.TvApiService
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
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
    fun provideRepository(
        tvApiService: TvApiService,
        mapper: Mapper,
        appDataBase: AppDataBase
    ): Repository = RepositoryImpl(tvApiService, mapper, appDataBase)
}