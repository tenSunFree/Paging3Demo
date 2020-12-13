package com.example.paging3demo.common.di

import com.example.paging3demo.main.model.remote.MainWebService
import com.example.paging3demo.main.model.remote.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(
    mainWebService: MainWebService
) : MainRepository =
    MainRepository(mainWebService)