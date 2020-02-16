package com.maicondcastro.worldheritages.heritage.data.datasource

import com.maicondcastro.worldheritages.BaseTest
import com.maicondcastro.worldheritages.heritage.data.datasource.local.HeritageDAO
import com.maicondcastro.worldheritages.heritage.di.heritageModule
import com.maicondcastro.worldheritages.util.HeritageTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class HeritageDataSourceTest : BaseTest(), HeritageTestHelper {

    private val dataSource: HeritageDataSource by inject()
    private val dao: HeritageDAO by inject()

    override fun setup() {
        MockitoAnnotations.initMocks(this)
        startKoin { modules(listOf(heritageModule)) }
        declareMock<HeritageDAO>()
    }

    override fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Should return a VALID list of heritages WHEN calling getHeritages succeeds`() {
        runBlocking {
            val heritageList = createHeritageLocalList()
            `when`(dao.getHeritage()).thenReturn(heritageList)

            val result = dataSource.getHeritage()
            assertEquals(heritageList, result)
        }
    }

    @Test
    fun `Should call DAO's save WHEN calling save`() {
        runBlocking {
            val heritage = createHeritageLocalList()
            dataSource.save(heritage)
            verify(dao, times(heritage.size)).save(heritage[0])
        }
    }
}