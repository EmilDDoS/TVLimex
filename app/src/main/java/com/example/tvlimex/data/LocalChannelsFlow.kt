package com.example.tvlimex.data

import com.example.tvlimex.domain.model.Channel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

object LocalChannelsFlow {

    private var localChannelsList = MutableSharedFlow<List<Channel>>(
        1,
        1,
        BufferOverflow.DROP_OLDEST).also { it.tryEmit(listOf()) }

    fun getListChannel(): Flow<List<Channel>> = localChannelsList

    fun setListChannel(list: List<Channel>) {
        localChannelsList.tryEmit(list)
    }
}