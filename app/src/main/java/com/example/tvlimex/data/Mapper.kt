package com.example.tvlimex.data

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
}