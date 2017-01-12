package com.dynobjx.kotlinsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dynobjx.kotlinsample.helpers.BusSingleton

/**
 * Created by root on 1/12/17.
 */
open class BaseActivity : AppCompatActivity() {

    fun showToast(message : String?) = Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()

    fun animateToLeft(act : AppCompatActivity) {
        //act.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    fun animateToRight(act : AppCompatActivity) {
        //act.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    fun moveToOtherActivity(intent : Intent) {
        startActivity(intent)
    }

    override fun onResume() {
        BusSingleton.instance.register(this)
        super.onResume()
    }

    override fun onPause() {
        BusSingleton.instance.unregister(this)
        super.onPause()
    }
}