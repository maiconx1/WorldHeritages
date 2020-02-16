package com.maicondcastro.worldheritages.main.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.common.util.observe
import com.maicondcastro.worldheritages.main.presentation.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setObservers()
        setupView()
    }

    private fun setupView() {
        viewModel.fetchHeritageJson(this)
    }

    private fun setObservers() {
        observe(viewModel.shouldOpenMain) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}