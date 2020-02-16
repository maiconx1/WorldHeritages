package com.maicondcastro.worldheritages.heritage.data.repository.impl

import com.maicondcastro.worldheritages.heritage.data.datasource.HeritageDataSource
import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository

class HeritageRepositoryImpl(
    private val dataSource: HeritageDataSource
) : HeritageRepository {
    override suspend fun getHeritage(): List<HeritageLocal> = dataSource.getHeritage()

    override suspend fun save(heritages: List<HeritageLocal>) {
        dataSource.save(heritages)
    }
}