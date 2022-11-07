package com.example.tvlimex.domain

import com.example.tvlimex.data.db.ChannelDbModel
import com.example.tvlimex.domain.model.Channel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getChannels(): List<Channel>

    fun getListChannel(): Flow<List<Channel>>

    fun setListChannel(list: List<Channel>)

    fun getListChannelsDb(): List<Channel>

    suspend fun addChannelDb(channel: Channel)

    suspend fun deleteChannelItem(channelId: Int)
}