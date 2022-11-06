package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase

class FavoriteChannelsViewModel(
    private val getChannelUseCase: GetChannelsUseCase,
    private val getLocalChannelsUseCase: GetLocalChannelsUseCase
) : ViewModel() {

    val localChannel = getLocalChannelsUseCase.getLocalListChannel()
}