package com.timmy.codelab.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.timmy.codelab.viewmodel.arch.ViewBindingActivity
import com.timmy.codelab.viewmodel.databinding.ActivityTestBinding
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class Test3Activity : ViewBindingActivity<ActivityTestBinding>() {

    private val TAG = this::class.java.simpleName

    companion object {
        fun createIntent(
            context: Context,
            id: String,
            name: String
        ) = Intent(context, Test3Activity::class.java).apply {
            putExtras(HasSavedStateHandleViewModel.createDefaultArgs(id, name))
        }
    }

    private val viewModel: HasSavedStateHandleViewModel by stateViewModel(
        state = { intent.extras ?: Bundle() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.test.text = "Test3\nViewModel construct only has savedStateHandle, use koin."
        Log.i(TAG, "TimmmmmmY onCreate, savedInstanceState: $savedInstanceState")
        Log.i(TAG, "TimmmmmmY onCreate, viewModel: $viewModel")
        viewModel.hello()
    }

    override fun createViewBinding(inflater: LayoutInflater) =
        ActivityTestBinding.inflate(layoutInflater)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "TimmmmmmY onSaveInstanceState, outState: $outState")
        outState.putString("AAA", "AAA")
    }
}