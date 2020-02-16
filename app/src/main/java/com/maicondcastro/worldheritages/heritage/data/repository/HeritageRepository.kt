package com.maicondcastro.worldheritages.heritage.data.repository

import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal

interface HeritageRepository {
    suspend fun getHeritage() : List<HeritageLocal>
    suspend fun save(heritages: List<HeritageLocal>)
}