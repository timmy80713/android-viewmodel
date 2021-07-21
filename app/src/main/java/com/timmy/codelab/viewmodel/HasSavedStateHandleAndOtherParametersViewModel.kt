package com.timmy.codelab.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle

class HasSavedStateHandleAndOtherParametersViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val tag: String
) : HasSavedStateHandleViewModel(savedStateHandle) {

    private val TAG = this::class.java.simpleName

    init {
        Log.i(TAG, "TimmmmmmY tag: $tag")
    }
}