package com.dynobjx.kotlinsample.helpers

import com.dynobjx.kotlinsample.models.Post
import com.dynobjx.kotlinsample.models.PostComment
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
import java.util.*

/**
 * Created by root on 1/16/17.
 */
interface JsonApi {

    @GET("/posts")
    fun getPost(): Observable<ArrayList<Post>>

    @GET("/posts/{postId}/comments")
    fun getCommentOfPost(@Path("postId") postId: Long): Observable<ArrayList<PostComment>>
}