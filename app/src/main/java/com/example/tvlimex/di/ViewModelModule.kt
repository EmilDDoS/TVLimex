package com.example.tvlimex.di

import androidx.lifecycle.ViewModel
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase
import com.example.tvlimex.presentation.screens.AllChannelsViewModel
import com.example.tvlimex.presentation.screens.FavoriteChannelsViewModel
import com.example.tvlimex.presentation.screens.GeneralViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ClassKey(GeneralViewModel::class)
    @Provides
    fun getGeneralViewModel(
        getChannelsUseCase: GetChannelsUseCase
    ): ViewModel = GeneralViewModel(getChannelsUseCase)

    @IntoMap
    @ClassKey(AllChannelsViewModel::class)
    @Provides
    fun getAllChannelsViewModel(
        getChannelsUseCase: GetChannelsUseCase,
        getLocalChannelsUseCase: GetLocalChannelsUseCase
    ): ViewModel = AllChannelsViewModel(getChannelsUseCase, getLocalChannelsUseCase)

    @IntoMap
    @ClassKey(FavoriteChannelsViewModel::class)
    @Provides
    fun getFavoriteChannelsViewModel(
        getLocalChannelsUseCase: GetLocalChannelsUseCase
    ): ViewModel = FavoriteChannelsViewModel(getLocalChannelsUseCase)
}