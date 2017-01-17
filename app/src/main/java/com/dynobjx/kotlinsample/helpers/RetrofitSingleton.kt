package com.dynobjx.kotlinsample.helpers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by root on 1/16/17.
 */
object RetrofitSingleton {
    lateinit var apiInterface: JsonApi
    private val gson: Gson = GsonBuilder().setLenient().create()
    val instance = this

    fun initRetrofit(client: OkHttpClient) {
        val retrofit: Retrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
        apiInterface = retrofit.create(JsonApi::class.java)
    }
}