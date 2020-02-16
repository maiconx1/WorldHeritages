package com.maicondcastro.worldheritages.di

import android.app.Application
import com.maicondcastro.worldheritages.heritage.di.heritageModule
import com.maicondcastro.worldheritages.main.presentation.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object Koin {

    @JvmField
    val MODULES: List<Module> = listOf(
        globalModule,
        localModule,
        heritageModule,
        splashModule
    )

    @JvmStatic
    fun initialize(application: Application) {
        startKoin {
            androidContext(application)
            modules(MODULES)
        }
    }
}