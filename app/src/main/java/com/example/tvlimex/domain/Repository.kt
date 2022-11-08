package com.example.tvlimex.domain

import com.example.tvlimex.domain.model.Channel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getChannels(): List<Channel>

    suspend fun getListChannelsDb(): Flow<List<Channel>>

    suspend fun addChannelDb(channel: Channel)

    suspend fun deleteChannelItem(channelId: Int)
}