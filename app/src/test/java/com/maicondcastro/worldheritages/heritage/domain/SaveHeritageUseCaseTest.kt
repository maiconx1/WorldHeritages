package com.maicondcastro.worldheritages.heritage.domain

import com.maicondcastro.worldheritages.BaseTest
import com.maicondcastro.worldheritages.common.util.mapToLocal
import com.maicondcastro.worldheritages.heritage.di.heritageModule
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository
import com.maicondcastro.worldheritages.util.HeritageTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.inject
import org.mockito.MockitoAnnotations
import org.koin.test.mock.declareMock
import org.mockito.Mockito.verify

class SaveHeritageUseCaseTest : BaseTest(), HeritageTestHelper {

    private val useCase: SaveHeritageUseCase by inject()
    private val repository: HeritageRepository by inject()

    override fun setup() {
        startKoin { modules(listOf(heritageModule)) }
        MockitoAnnotations.initMocks(this)
        declareMock<HeritageRepository>()
    }

    override fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Should call Save method from Repository when execute the use case with Heritage list`() {
        runBlocking {
            val heritage = createHeritageDomainList()
            useCase.execute(heritage)
            verify(repository).save(heritage.mapToLocal())
        }
    }
}