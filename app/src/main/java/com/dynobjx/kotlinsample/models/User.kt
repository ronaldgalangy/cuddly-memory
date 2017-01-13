package com.dynobjx.kotlinsample.models

/**
 * Created by root on 1/13/17.
 */
class User constructor(id: String) {
    lateinit var userName: String
    lateinit var password: String



    init {
        println("init block")
    }
}