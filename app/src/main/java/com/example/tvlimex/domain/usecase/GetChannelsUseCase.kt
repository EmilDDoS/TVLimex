package com.example.tvlimex.domain.usecase

import com.example.tvlimex.domain.Repository

class GetChannelsUseCase(private val repository: Repository) {
    suspend fun getChannels() = repository.getChannels()
}