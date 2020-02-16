package com.maicondcastro.worldheritages.common.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateInto(@LayoutRes layoutResId: Int): View = LayoutInflater.from(context)
    .inflate(layoutResId, this, false)