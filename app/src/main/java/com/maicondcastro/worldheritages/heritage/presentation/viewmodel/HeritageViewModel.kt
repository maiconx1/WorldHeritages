package com.maicondcastro.worldheritages.heritage.presentation.viewmodel

import com.maicondcastro.worldheritages.common.presentation.viewmodel.BaseViewModel
import com.maicondcastro.worldheritages.common.presentation.viewmodel.ThreadContextProvider
import com.maicondcastro.worldheritages.common.util.Constants
import com.maicondcastro.worldheritages.common.util.SingleLiveEvent
import com.maicondcastro.worldheritages.common.util.mapToView
import com.maicondcastro.worldheritages.heritage.domain.GetHeritageUseCase
import com.maicondcastro.worldheritages.heritage.presentation.HeritageInteractor
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView
import kotlin.math.min

class HeritageViewModel(
    private val getHeritageUseCase: GetHeritageUseCase,
    threadContextProvider: ThreadContextProvider
) : BaseViewModel(threadContextProvider), HeritageInteractor.ViewModel {

    val liveHeritage: SingleLiveEvent<List<HeritageView>> = SingleLiveEvent()
    private val heritageList: MutableList<HeritageView> = mutableListOf()
    val qtdPages: Int
        get() = _qtdPages
    private var _qtdPages: Int = 0
    val page: Int
        get() = _page
    private var _page: Int = 0

    override fun showMore(id: Long) {
        val heritage = heritageList.find { it.listId == id }
        heritage?.let {
            it.showingInfo = !it.showingInfo
            heritageList[heritageList.indexOf(it)] = it
        }
    }

    private fun getHeritages() {
        launchIO {
            val heritages = getHeritageUseCase.execute()
            _qtdPages = heritages.size / Constants.HERITAGE_PER_PAGE
            heritageList.clear()
            heritageList.addAll(
                heritages.subList(
                    page * Constants.HERITAGE_PER_PAGE,
                    min((page + 1) * Constants.HERITAGE_PER_PAGE, heritages.size)
                ).mapIndexed { index, heritage ->
                    val view = heritage.mapToView()
                    view.listId = index.toLong()
                    view.showingInfo = false
                    view
                })
            liveHeritage.postValue(heritageList)
        }
    }

    fun firstPage() {
        _page = 0
        getHeritages()
    }

    fun previousPage() {
        if (page > 0) {
            _page--
            getHeritages()
        }
    }

    fun nextPage() {
        if (page < qtdPages) {
            _page++
            getHeritages()
        }
    }

    fun lastPage() {
        _page = qtdPages
        getHeritages()
    }
}