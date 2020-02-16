package com.maicondcastro.worldheritages.heritage.data.datasource.impl

import com.maicondcastro.worldheritages.heritage.data.datasource.HeritageDataSource
import com.maicondcastro.worldheritages.heritage.data.datasource.local.HeritageDAO
import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal

class HeritageDataSourceImpl(private val dao: HeritageDAO) : HeritageDataSource {
    override suspend fun getHeritage(): List<HeritageLocal> = dao.getHeritage()

    override suspend fun save(heritages: List<HeritageLocal>) {
        heritages.forEach {
            dao.save(it)
        }
    }

}