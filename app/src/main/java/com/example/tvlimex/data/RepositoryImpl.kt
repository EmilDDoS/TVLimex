package com.example.tvlimex.data

import com.example.tvlimex.data.network.TvApiFactory
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.model.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class RepositoryImpl(
    private val tvApi: TvApiFactory,
    private val mapper: Mapper,
    private val localChannelsFlow: LocalChannelsFlow
) : Repository {

    override suspend fun getChannels(): List<Channel> {
        val result = tvApi.instance.getTvDto()
        return mapper.mapTvDtoToChannel(result)
    }

    override fun getListChannel() = localChannelsFlow.getListChannel()

    override fun setListChannel(list: List<Channel>) { localChannelsFlow.setListChannel(list) }
}