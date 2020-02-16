package com.maicondcastro.worldheritages.heritage.domain

import com.maicondcastro.worldheritages.common.domain.UseCaseInteractor
import com.maicondcastro.worldheritages.common.util.mapToDomain
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository
import com.maicondcastro.worldheritages.heritage.domain.entity.Heritage

class GetHeritageUseCase(private val heritageRepository: HeritageRepository?) :
    UseCaseInteractor<Nothing, List<Heritage>> {
    override suspend fun execute(params: Nothing?): List<Heritage> =
        heritageRepository?.getHeritage()?.mapToDomain() ?: listOf()

}