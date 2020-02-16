package com.maicondcastro.worldheritages.heritage.data.repository

import com.maicondcastro.worldheritages.BaseTest
import com.maicondcastro.worldheritages.heritage.data.datasource.HeritageDataSource
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
import org.mockito.Mockito.*

class HeritageRepositoryTest : BaseTest(), HeritageTestHelper {

    private val repository: HeritageRepository by inject()

    private val dataSource: HeritageDataSource by inject()

    override fun setup() {
        MockitoAnnotations.initMocks(this)
        startKoin { modules(listOf(heritageModule)) }
        declareMock<HeritageDataSource>()
    }

    override fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Should call Save method from DataSource when repository save a new heritage`() {
        runBlocking {
            val domainHeritage = createHeritageLocalList()
            repository.save(domainHeritage)
            verify(dataSource).save(domainHeritage)
        }
    }

    @Test
    fun `Should return a VALID list of heritages WHEN calling getHeritages succeeds`() {
        runBlocking {
            val heritageLocalList = createHeritageLocalList()
            `when`(dataSource.getHeritage()).thenReturn(heritageLocalList)
            val result = repository.getHeritage()
            assertEquals(heritageLocalList, result)
        }
    }
}