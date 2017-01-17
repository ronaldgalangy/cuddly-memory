package com.dynobjx.kotlinsample.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by root on 1/16/17.
 */
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}