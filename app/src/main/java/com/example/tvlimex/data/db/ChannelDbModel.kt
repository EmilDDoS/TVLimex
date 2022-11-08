package com.example.tvlimex.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME = "channels_table"

@Entity(tableName = TABLE_NAME)
data class ChannelDbModel(
    @PrimaryKey
    val id: Int,
    val nameRu: String,
    val image: String,
    val title: String,
    val url: String,
)
