package com.dynobjx.kotlinsample

import android.os.Bundle
import android.widget.TextView
import butterknife.bindView

class MainActivity : BaseActivity() {

    val helloWorld: TextView by bindView(R.id.tv_hello_world)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorld.setOnClickListener {
            showToast("Hi!!")
        }
    }
}
