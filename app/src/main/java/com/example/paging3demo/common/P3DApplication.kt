package com.example.paging3demo.common

import android.app.Application
import com.example.paging3demo.common.di.viewModelModule
import com.example.paging3demo.common.di.networkModule
import com.example.paging3demo.common.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class P3DApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@P3DApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}