package com.example.tvlimex.data.entity

data class TvDto(
    val channels: List<ChannelDto>,
    val ckey: String,
    val valid: Int
)