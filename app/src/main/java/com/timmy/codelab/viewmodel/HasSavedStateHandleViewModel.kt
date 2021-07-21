package com.timmy.codelab.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

open class HasSavedStateHandleViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val TAG = this::class.java.simpleName

    companion object {
        private const val BUNDLE_DEFAULT_ID = "BUNDLE_DEFAULT_ID"
        private const val BUNDLE_DEFAULT_NAME = "BUNDLE_DEFAULT_NAME"
        private const val BUNDLE_SAVED_ARGS = "BUNDLE_SAVED_ARGS"
        fun createDefaultArgs(
            id: String,
            name: String
        ) = Bundle().apply {
            putString(BUNDLE_DEFAULT_ID, id)
            putString(BUNDLE_DEFAULT_NAME, name)
        }
    }

    init {
        savedStateHandle.setSavedStateProvider(BUNDLE_SAVED_ARGS) {
            val bundle = if (savedStateHandle.contains(BUNDLE_SAVED_ARGS)) {
                savedStateHandle.get<Bundle>(BUNDLE_SAVED_ARGS)!!
            } else {
                Bundle()
            }
            bundle.apply {
                putString("BBB", "BBB")
            }
        }
        Log.i(TAG, "TimmmmmmY init, savedStateHandle keys: ${savedStateHandle.keys()}")
        for (key in savedStateHandle.keys()) {
            val value = savedStateHandle.get<Any>(key)
            val type = if (null == value) "" else "(${value::class.java.simpleName})"
            Log.i(TAG, "TimmmmmmY init, savedStateHandle: $key => $value $type")
            (value as? Bundle)?.keySet()?.forEach {
                Log.i(TAG, "TimmmmmmY init, savedStateHandle: $key is bundle, $it => ${value[it]}")
            }
        }
    }

    fun hello() {
        Log.i(TAG, "TimmmmmmY hello, savedStateHandle keys: ${savedStateHandle.keys()}")
        for (key in savedStateHandle.keys()) {
            val value = savedStateHandle.get<Any>(key)
            val type = if (null == value) "" else "(${value::class.java.simpleName})"
            Log.i(TAG, "TimmmmmmY hello, savedStateHandle: $key => $value $type")
            (value as? Bundle)?.keySet()?.forEach {
                Log.i(TAG, "TimmmmmmY hello, savedStateHandle: $key is bundle, $it => ${value[it]}")
            }
        }
    }
}