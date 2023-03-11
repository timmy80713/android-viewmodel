package com.timmy.codelab.viewmodel.injection

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.timmy.codelab.viewmodel")
class AppModule {
    @Single
    fun dummy() {
        return
    }
}