package com.maicondcastro.worldheritages.heritage.di

import com.maicondcastro.worldheritages.common.data.datasource.WorldHeritagesDatabase
import com.maicondcastro.worldheritages.heritage.data.datasource.HeritageDataSource
import com.maicondcastro.worldheritages.heritage.data.datasource.impl.HeritageDataSourceImpl
import com.maicondcastro.worldheritages.heritage.data.repository.HeritageRepository
import com.maicondcastro.worldheritages.heritage.data.repository.impl.HeritageRepositoryImpl
import com.maicondcastro.worldheritages.heritage.domain.GetHeritageUseCase
import com.maicondcastro.worldheritages.heritage.domain.SaveHeritageUseCase
import com.maicondcastro.worldheritages.heritage.presentation.ui.HeritageDetailFragment
import com.maicondcastro.worldheritages.heritage.presentation.ui.HeritageFragment
import com.maicondcastro.worldheritages.heritage.presentation.ui.adapter.HeritageAdapter
import com.maicondcastro.worldheritages.heritage.presentation.viewmodel.HeritageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val heritageModule = module {
    single { get<WorldHeritagesDatabase>().heritageDAO() }
    single<HeritageDataSource> { HeritageDataSourceImpl(dao = get()) }
    single<HeritageRepository> {
        HeritageRepositoryImpl(
            dataSource = get()
        )
    }
    factory { GetHeritageUseCase(heritageRepository = get()) }
    factory { SaveHeritageUseCase(heritageRepository = get()) }

    viewModel { HeritageViewModel(getHeritageUseCase = get(), threadContextProvider = get()) }

    scope(named<HeritageFragment>()) {
        scoped { (viewModel: HeritageViewModel) ->
            HeritageAdapter(
                viewModel
            )
        }
    }
}