package com.example.tvlimex.data

import com.example.tvlimex.data.db.AppDataBase
import com.example.tvlimex.data.network.TvApiService
import com.example.tvlimex.domain.Repository
import com.example.tvlimex.domain.model.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

class RepositoryImpl(
    private val tvApi: TvApiService,
    private val mapper: Mapper,
    private val localChannelsFlow: LocalChannelsFlow,
    private val appDataBase: AppDataBase
) : Repository {

    override suspend fun getChannels(): List<Channel> {
        val result = tvApi.getTvDto()
        return mapper.mapTvDtoToChannel(result)
    }

    override fun getListChannel() = localChannelsFlow.getListChannel()

    override fun setListChannel(list: List<Channel>) {
        localChannelsFlow.setListChannel(list)
    }

    override suspend fun getListChannelsDb(): Flow<List<Channel>> {
        return appDataBase.tvDao().getListChannelsDb().map {
            it.map { channelDb ->
                mapper.mapChannelDbModelToChannel(channelDb)
            }
        }
    }

    override suspend fun addChannelDb(channel: Channel) {
        appDataBase.tvDao().addChannelDb(mapper.mapChannelToChannelDbModel(channel))
    }

    override suspend fun deleteChannelItem(channelId: Int) {
        appDataBase.tvDao().deleteChannelItem(channelId)
    }
}