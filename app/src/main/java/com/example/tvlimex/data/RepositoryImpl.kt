package com.example.tvlimex.data

import com.example.tvlimex.data.network.TvApiService
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.model.Channel

class RepositoryImpl(
    private val tvApi: TvApiService,
    private val mapper: Mapper,
    private val localChannelsFlow: LocalChannelsFlow
) : Repository {

    override suspend fun getChannels(): List<Channel> {
        val result = tvApi.getTvDto()
        return mapper.mapTvDtoToChannel(result)
    }

    override fun getListChannel() = localChannelsFlow.getListChannel()

    override fun setListChannel(list: List<Channel>) { localChannelsFlow.setListChannel(list) }
}