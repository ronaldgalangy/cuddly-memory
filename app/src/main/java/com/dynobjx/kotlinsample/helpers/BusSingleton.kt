package com.dynobjx.kotlinsample.helpers

import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer

/**
 * Created by rsbulanon on 8/30/16.
 */
object BusSingleton {

    val instance = Bus(ThreadEnforcer.ANY)
}
