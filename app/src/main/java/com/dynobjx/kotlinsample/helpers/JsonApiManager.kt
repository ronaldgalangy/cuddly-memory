package com.dynobjx.kotlinsample.helpers

import com.dynobjx.kotlinsample.models.Post
import com.dynobjx.kotlinsample.models.Response
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by root on 1/16/17.
 */
class JsonApiManager constructor(val callBack: (Response) -> Unit){

    private val retrofitSingleton: RetrofitSingleton = RetrofitSingleton.instance

    fun getPost(): MutableList<Post> {
        retrofitSingleton.apiInterface.getPost()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ callBack(Response("post", it)) }, Throwable::printStackTrace, { println("ocmplete") })
        return mutableListOf()
    }

    fun getCommentOfPost(postId: Long) {
        retrofitSingleton.apiInterface.getCommentOfPost(postId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ callBack(Response("comment", it)) }, Throwable::printStackTrace, { println("ocmplete") })
    }
}