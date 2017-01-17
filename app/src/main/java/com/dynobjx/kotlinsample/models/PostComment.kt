package com.dynobjx.kotlinsample.models

/**
 * Created by root on 1/17/17.
 */
data class PostComment(var postId: Long,
                       var id: Long,
                       var name: String,
                       var email: String,
                       var body: String)