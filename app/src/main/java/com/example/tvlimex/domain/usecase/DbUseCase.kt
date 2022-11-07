package com.example.tvlimex.domain.usecase

import com.example.tvlimex.data.db.ChannelDbModel
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.model.Channel

class DbUseCase(private val repository: Repository) {

    suspend fun getListChannelsDb() = repository.getListChannelsDb()

    suspend fun addChannelDb(channel: Channel) {
        repository.addChannelDb(channel)
    }

    suspend fun deleteChannelItem(channelId: Int) {
        repository.deleteChannelItem(channelId)
    }
}