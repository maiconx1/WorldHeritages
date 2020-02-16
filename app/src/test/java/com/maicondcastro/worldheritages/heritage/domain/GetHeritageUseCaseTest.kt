package com.maicondcastro.worldheritages.heritage.domain

import com.maicondcastro.worldheritages.BaseTest
import com.maicondcastro.worldheritages.common.util.mapToDomain
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository
import com.maicondcastro.worldheritages.heritage.di.heritageModule
import com.maicondcastro.worldheritages.util.HeritageTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.inject
import org.mockito.MockitoAnnotations
import org.junit.Assert.assertEquals
import org.koin.test.mock.declareMock
import org.mockito.Mockito.`when`

class GetHeritageUseCaseTest : BaseTest(), HeritageTestHelper {

    private val useCase: GetHeritageUseCase by inject()
    private val heritageRepository: HeritageRepository by inject()

    override fun setup() {
        MockitoAnnotations.initMocks(this)
        startKoin { modules(listOf(heritageModule)) }
        declareMock<HeritageRepository>()
    }

    override fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Should return a VALID list of heritages WHEN executing with right params`() {
        runBlocking {
            val heritagesList = createHeritageLocalList()
            `when`(heritageRepository.getHeritage()).thenReturn(heritagesList)
            val result = useCase.execute()
            assertEquals(heritagesList.mapToDomain(), result)
        }
    }

    @Test
    fun `Should return a EMPTY list WHEN repository returns null`() {
        runBlocking {
            `when`(heritageRepository.getHeritage()).thenReturn(null)
            val result = useCase.execute()
            assert(result.isEmpty())
        }
    }
}