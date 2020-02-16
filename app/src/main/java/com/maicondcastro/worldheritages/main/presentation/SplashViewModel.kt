package com.maicondcastro.worldheritages.main.presentation

import android.content.Context
import com.google.gson.Gson
import com.maicondcastro.worldheritages.common.presentation.viewmodel.BaseViewModel
import com.maicondcastro.worldheritages.common.presentation.viewmodel.ThreadContextProvider
import com.maicondcastro.worldheritages.common.util.SingleLiveEvent
import com.maicondcastro.worldheritages.common.util.getJsonDataFromAsset
import com.maicondcastro.worldheritages.common.util.mapToDomain
import com.maicondcastro.worldheritages.heritage.domain.GetHeritageUseCase
import com.maicondcastro.worldheritages.heritage.domain.SaveHeritageUseCase
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView

class SplashViewModel(
    private val saveHeritageUseCase: SaveHeritageUseCase,
    private val getHeritageUseCase: GetHeritageUseCase,
    threadContextProvider: ThreadContextProvider
) : BaseViewModel(threadContextProvider) {

    val shouldOpenMain = SingleLiveEvent<Boolean>()

    fun fetchHeritageJson(context: Context) {
        launchIO {
            if (getHeritageUseCase.execute().isEmpty()) {
                val json = context.getJsonDataFromAsset("real.planet.world-heritage.json")
                val heritages = Gson().fromJson(json, Array<HeritageView>::class.java).toList()
                saveHeritageUseCase.execute(heritages.map { it.mapToDomain() })
            }
            shouldOpenMain.postValue(true)
        }
    }
}