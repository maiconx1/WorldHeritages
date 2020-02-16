package com.maicondcastro.worldheritages.heritage.domain

import com.maicondcastro.worldheritages.common.domain.UseCaseInteractor
import com.maicondcastro.worldheritages.common.util.mapToLocal
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository
import com.maicondcastro.worldheritages.heritage.domain.entity.Heritage

class SaveHeritageUseCase(private val heritageRepository: HeritageRepository?) :
    UseCaseInteractor<List<Heritage>, Unit> {
    override suspend fun execute(params: List<Heritage>?) {
        val list = params ?: listOf()
        heritageRepository?.save(list.mapToLocal())
    }

}