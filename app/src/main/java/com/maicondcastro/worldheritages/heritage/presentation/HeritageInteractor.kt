package com.maicondcastro.worldheritages.heritage.presentation

import com.maicondcastro.worldheritages.common.presentation.ui.ViewInteractor
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView

interface HeritageInteractor {
    interface View : ViewInteractor {

        fun fetchHeritage()
        fun setListeners()
        fun startObservers()
        fun setRecyclerView()
        fun changeList(list: List<HeritageView>)
    }

    interface ViewModel {

        fun showMore(id: Long)
    }
}