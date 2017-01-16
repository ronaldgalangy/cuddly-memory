package com.dynobjx.kotlinsample

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import com.dynobjx.kotlinsample.adapters.PostAdapter
import com.dynobjx.kotlinsample.models.Post
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: PostAdapter
    private var posts: MutableList<Post> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipe_refresh.setOnRefreshListener(this)

        (1..100).mapTo(posts) { Post(it.toString(), it.toString(), it.toString(), "body : $it") }
        rv_post.setHasFixedSize(true)
        adapter = PostAdapter(this, posts, { showToast(it.body) })
        rv_post.adapter = adapter
    }

    override fun onRefresh() {
        println("swipe to refresh action")
        showToast("swipe to refresh action")
    }
}
