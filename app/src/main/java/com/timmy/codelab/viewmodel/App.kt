package com.timmy.codelab.viewmodel

import android.app.Application
import com.timmy.codelab.viewmodel.di.viewModelModule
import com.timmy.codelab.viewmodel.injection.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.ksp.generated.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appContext = this
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(appContext)
            modules(
                viewModelModule,
                AppModule().module,
            )
        }
    }
}