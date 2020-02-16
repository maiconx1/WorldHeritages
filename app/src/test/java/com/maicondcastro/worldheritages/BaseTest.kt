package com.maicondcastro.worldheritages

import org.junit.After
import org.junit.Before
import org.koin.test.KoinTest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
abstract class BaseTest : KoinTest {

    @Before
    abstract fun setup()

    @After
    abstract fun tearDown()
}
