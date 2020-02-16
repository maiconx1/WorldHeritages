package com.maicondcastro.worldheritages.di

import androidx.room.Room
import com.maicondcastro.worldheritages.common.data.datasource.WorldHeritagesDatabase
import com.maicondcastro.worldheritages.common.presentation.viewmodel.ThreadContextProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            WorldHeritagesDatabase::class.java,
            WorldHeritagesDatabase.NAME
        ).build()
    }
}

val globalModule = module {
    factory { ThreadContextProvider() }
}