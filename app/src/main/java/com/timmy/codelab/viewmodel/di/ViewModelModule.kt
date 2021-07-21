package com.timmy.codelab.viewmodel.di

import androidx.lifecycle.SavedStateHandle
import com.timmy.codelab.viewmodel.HasSavedStateHandleAndOtherParametersViewModel
import com.timmy.codelab.viewmodel.HasSavedStateHandleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HasSavedStateHandleViewModel(savedStateHandle = get())
    }
    viewModel { (savedStateHandle: SavedStateHandle, tag: String) ->
        HasSavedStateHandleAndOtherParametersViewModel(
            savedStateHandle = savedStateHandle,
            tag = tag
        )
    }
}