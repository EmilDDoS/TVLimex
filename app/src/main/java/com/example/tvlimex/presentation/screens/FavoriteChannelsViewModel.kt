package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase

class FavoriteChannelsViewModel(
    private val getLocalChannelsUseCase: GetLocalChannelsUseCase,
    dbUseCase: DbUseCase
) : ViewModel() {

    val localChannel = getLocalChannelsUseCase.getLocalListChannel()

    fun setListChannels(list: List<Channel>){
        getLocalChannelsUseCase.setLocalListChannel(list)
    }
}