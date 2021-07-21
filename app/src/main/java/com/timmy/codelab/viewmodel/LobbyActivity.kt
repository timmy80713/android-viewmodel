package com.timmy.codelab.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import com.timmy.codelab.viewmodel.arch.ViewBindingActivity
import com.timmy.codelab.viewmodel.databinding.ActivityLobbyBinding

class LobbyActivity : ViewBindingActivity<ActivityLobbyBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    override fun createViewBinding(inflater: LayoutInflater) =
        ActivityLobbyBinding.inflate(layoutInflater)

    private fun setupView() {
        viewBinding.one.setOnClickListener {
            startActivity(Test1Activity.createIntent(context = this, id = "9453", name = "就是五桑"))
        }
        viewBinding.two.setOnClickListener {
            startActivity(Test2Activity.createIntent(context = this, id = "9453", name = "就是五桑"))
        }
        viewBinding.three.setOnClickListener {
            startActivity(Test3Activity.createIntent(context = this, id = "9453", name = "就是五桑"))
        }
        viewBinding.four.setOnClickListener {
            startActivity(Test4Activity.createIntent(context = this, id = "9453", name = "就是五桑"))
        }
    }
}