package com.maicondcastro.worldheritages

import android.app.Application
import com.maicondcastro.worldheritages.di.Koin

class WorldHeritagesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Koin.initialize(this)
    }
}