package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import com.example.tvlimex.domain.usecase.GetLocalChannelsUseCase
import kotlinx.coroutines.launch

class AllChannelsViewModel(
    private val getChannelUseCase: GetChannelsUseCase,
    private val getLocalChannelsUseCase: GetLocalChannelsUseCase,
    private val dbUseCase: DbUseCase
) : ViewModel() {

    val localChannel = getLocalChannelsUseCase.getLocalListChannel()

    fun getChannel() {
        viewModelScope.launch {
            try {
                val result = getChannelUseCase.getChannels()
                setListChannels(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun setListChannels(list: List<Channel>){
        getLocalChannelsUseCase.setLocalListChannel(list)
    }

    fun getListChannelsFromDb() = dbUseCase.getListChannelsDb()
}