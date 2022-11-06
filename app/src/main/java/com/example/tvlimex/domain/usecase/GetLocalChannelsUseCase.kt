package com.example.tvlimex.domain.usecase

import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.model.Channel

class GetLocalChannelsUseCase(
    private val repository: Repository
) {

    fun getLocalListChannel() = repository.getListChannel()

    fun setLocalListChannel(list: List<Channel>) { repository.setListChannel(list) }
}