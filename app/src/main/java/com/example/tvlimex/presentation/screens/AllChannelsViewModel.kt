package com.example.tvlimex.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvlimex.domain.model.Channel
import com.example.tvlimex.domain.usecase.DbUseCase
import com.example.tvlimex.domain.usecase.GetChannelsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllChannelsViewModel(
    private val getChannelUseCase: GetChannelsUseCase,
    private val dbUseCase: DbUseCase
) : ViewModel() {

    private val _channelsList = MutableStateFlow(listOf<Channel>())
    val channelList: StateFlow<List<Channel>>
        get() = _channelsList.asStateFlow()

    fun getChannel() {
        viewModelScope.launch {
            try {
                val result = getChannelUseCase.getChannels()
                _channelsList.tryEmit(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun getListChannelsFromDb() = dbUseCase.getListChannelsDb()

    fun addChannelDb(channel: Channel){
        viewModelScope.launch {
            dbUseCase.addChannelDb(channel)
        }
    }

    fun deleteChanel(id: Int){
        viewModelScope.launch {
            dbUseCase.deleteChannelItem(id)
        }
    }
}