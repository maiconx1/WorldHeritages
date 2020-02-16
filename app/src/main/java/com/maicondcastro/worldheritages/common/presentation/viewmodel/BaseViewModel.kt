package com.maicondcastro.worldheritages.common.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel(protected val threadContextProvider: ThreadContextProvider) :
    ViewModel() {

    private val job: Job by lazy { Job() }
    protected val coroutineScope: CoroutineScope by lazy { CoroutineScope(threadContextProvider.io + job) }

    protected inline fun launchIO(crossinline execution: suspend CoroutineScope.() -> Unit) {
        coroutineScope.launch(threadContextProvider.io) { execution() }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}