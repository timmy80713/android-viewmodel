package com.timmy.codelab.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.timmy.codelab.viewmodel.arch.ViewBindingActivity
import com.timmy.codelab.viewmodel.databinding.ActivityTestBinding

class Test2Activity : ViewBindingActivity<ActivityTestBinding>() {

    private val TAG = this::class.java.simpleName

    companion object {
        fun createIntent(
            context: Context,
            id: String,
            name: String
        ) = Intent(context, Test2Activity::class.java).apply {
            putExtras(HasSavedStateHandleViewModel.createDefaultArgs(id, name))
        }
    }

    private val viewModel: HasSavedStateHandleAndOtherParametersViewModel by viewModels {
        Test2ViewModelFactory(
            owner = this,
            defaultArgs = intent.extras!!,
            tag = TAG
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.test.text =
            "Test2\nViewModel construct has savedStateHandle and other parameters."
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