package com.dynobjx.kotlinsample

import android.app.Application
import com.dynobjx.kotlinsample.helpers.RetrofitSingleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by root on 1/16/17.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        /** initialize okhttp client */
        var cacheDir = externalCacheDir
        if (cacheDir == null) {
            cacheDir = getCacheDir()
        }
        val cache = Cache(cacheDir, (10 * 1024 * 1024).toLong())
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                    println("performing url --> ${request.url()}")
                    chain.proceed(request)
                }
                .cache(cache)
                .build()
        RetrofitSingleton.instance.initRetrofit(okHttpClient)
    }
}