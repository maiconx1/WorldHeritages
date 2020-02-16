package com.maicondcastro.worldheritages.heritage.data.datasource.local

import androidx.room.Dao
import androidx.room.Query
import com.maicondcastro.worldheritages.common.data.datasource.local.BaseDAO
import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal

@Dao
interface HeritageDAO : BaseDAO<HeritageLocal> {

    @Query("SELECT * FROM Heritage")
    fun getHeritage() : List<HeritageLocal>
}