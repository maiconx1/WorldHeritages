package com.maicondcastro.worldheritages.common.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maicondcastro.worldheritages.heritage.data.datasource.local.HeritageDAO
import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal

@Database(
    entities = [HeritageLocal::class],
    version = 1,
    exportSchema = false
)
abstract class WorldHeritagesDatabase : RoomDatabase() {

    abstract fun heritageDAO(): HeritageDAO

    companion object {
        const val NAME = "worldHeritages_db"
    }
}