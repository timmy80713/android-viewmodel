package com.timmy.codelab.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class Test2ViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle,
    private val tag: String,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return with(modelClass) {
            when {
                isAssignableFrom(HasSavedStateHandleAndOtherParametersViewModel::class.java) -> {
                    HasSavedStateHandleAndOtherParametersViewModel(handle, tag)
                }
                else -> throw IllegalArgumentException("Unknown ViewModel class =  ${modelClass.name}")
            }
        } as T
    }
}