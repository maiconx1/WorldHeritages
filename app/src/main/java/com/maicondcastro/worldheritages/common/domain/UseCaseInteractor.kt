package com.maicondcastro.worldheritages.common.domain

interface UseCaseInteractor<Params, out Output> {

    suspend fun execute(params: Params? = null): Output
}