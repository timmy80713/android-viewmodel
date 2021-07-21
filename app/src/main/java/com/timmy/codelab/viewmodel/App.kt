package com.timmy.codelab.viewmodel

import android.app.Application
import com.timmy.codelab.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appContext = this
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(appContext)
            modules(arrayListOf<Module>().apply {
                add(viewModelModule)
            })
        }
    }
}