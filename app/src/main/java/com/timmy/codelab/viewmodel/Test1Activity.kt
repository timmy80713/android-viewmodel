package com.timmy.codelab.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.timmy.codelab.viewmodel.arch.ViewBindingActivity
import com.timmy.codelab.viewmodel.databinding.ActivityTestBinding

class Test1Activity : ViewBindingActivity<ActivityTestBinding>() {

    private val TAG = this::class.java.simpleName

    companion object {
        fun createIntent(
            context: Context,
            id: String,
            name: String
        ) = Intent(context, Test1Activity::class.java).apply {
            putExtras(HasSavedStateHandleViewModel.createDefaultArgs(id, name))
        }
    }

    private val viewModel: HasSavedStateHandleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.test.text = "Test1\nViewModel construct only has savedStateHandle."
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