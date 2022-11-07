package com.example.tvlimex.data

import com.example.tvlimex.data.db.ChannelDbModel
import com.example.tvlimex.data.entity.TvDto
import com.example.tvlimex.domain.model.Channel

object Mapper {
    fun mapTvDtoToChannel(tvDto: TvDto) = tvDto.channels.map {
        Channel(
            id = it.id,
            nameRu = it.name_ru,
            image = it.image,
            title = it.current.title,
            url = it.url
        )
    }

    fun mapChannelDbModelToChannel(channelDbModel: ChannelDbModel) = Channel(
        id = channelDbModel.id,
        nameRu = channelDbModel.nameRu,
        image = channelDbModel.image,
        title = channelDbModel.title,
        url = channelDbModel.url,
        isActiveStar = true
    )

    fun mapChannelToChannelDbModel(channel: Channel) = ChannelDbModel(
        id = channel.id,
        nameRu = channel.nameRu,
        image = channel.image,
        title = channel.title,
        url = channel.url
    )
}