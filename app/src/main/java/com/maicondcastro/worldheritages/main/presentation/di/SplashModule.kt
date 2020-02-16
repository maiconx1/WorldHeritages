package com.maicondcastro.worldheritages.main.presentation.di

import com.maicondcastro.worldheritages.main.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    viewModel { SplashViewModel(saveHeritageUseCase = get(), getHeritageUseCase = get(), threadContextProvider = get()) }
}