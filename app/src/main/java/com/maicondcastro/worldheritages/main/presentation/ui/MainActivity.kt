package com.maicondcastro.worldheritages.main.presentation.ui

import android.os.Bundle
import android.view.MenuItem
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.common.presentation.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutResId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            back()
        }
        return super.onOptionsItemSelected(item)
    }

    fun back() {
        super.onBackPressed()
    }
}