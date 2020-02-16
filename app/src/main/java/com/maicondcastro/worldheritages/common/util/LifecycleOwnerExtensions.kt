package com.maicondcastro.worldheritages.common.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <reified T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline execution: (T) -> Unit) {
    liveData.observe(this, Observer { execution(it) })
}

inline fun <reified T> Fragment.observe(liveData: LiveData<T>, crossinline execution: (T) -> Unit) {
    liveData.observe(this, Observer { execution(it) })
}