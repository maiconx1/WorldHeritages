package com.maicondcastro.worldheritages.heritage.data.datasource

import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal

interface HeritageDataSource {

    suspend fun getHeritage() : List<HeritageLocal>
    suspend fun save(heritages: List<HeritageLocal>)
}