package com.maicondcastro.worldheritages.common.util

import android.content.Context
import java.io.IOException

fun Context.getJsonDataFromAsset(fileName: String) : String? {
    return try {
        assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
}