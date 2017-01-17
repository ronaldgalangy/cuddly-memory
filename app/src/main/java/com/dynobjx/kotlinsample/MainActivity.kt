package com.dynobjx.kotlinsample

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import com.dynobjx.kotlinsample.adapters.PostAdapter
import com.dynobjx.kotlinsample.helpers.JsonApiManager
import com.dynobjx.kotlinsample.models.Post
import com.dynobjx.kotlinsample.models.PostComment
import com.dynobjx.kotlinsample.models.Response
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: PostAdapter
    private var posts: MutableList<Post> = ArrayList()
    private val apiCall: JsonApiManager by lazy {
        JsonApiManager {
            if (it is Response) {
                when(it.requestType) {
                    "post" -> {
                        swipe_refresh.isEnabled = false
                        refresh()
                        this.posts.addAll(it.payLoad as ArrayList<Post>)
                    }
                    "comment" -> {
                        (it.payLoad as ArrayList<PostComment>).forEach { println(it.email) }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipe_refresh.setOnRefreshListener(this)

        rv_post.setHasFixedSize(true)
        adapter = PostAdapter(this, posts) {
            it -> apiCall.getCommentOfPost(it.id)
        }
        rv_post.adapter = adapter

        apiCall.getPost()
    }

    override fun onRefresh() {
        refresh()
        apiCall.getPost()
    }

    private fun refresh() {
        posts.clear()
        adapter.notifyDataSetChanged()
    }
}
