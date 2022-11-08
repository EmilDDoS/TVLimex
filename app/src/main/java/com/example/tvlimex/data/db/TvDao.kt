package com.example.tvlimex.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface TvDao {

    @Query("SELECT * FROM channels_table")
    fun getListChannelsDb(): Flow<List<ChannelDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addChannelDb(channelEntity: ChannelDbModel)

    @Query("DELETE FROM channels_table WHERE id=:channelId")
    suspend fun deleteChannelItem(channelId: Int)
}