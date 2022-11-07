package com.example.tvlimex.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ChannelDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun tvDao(): TvDao
}