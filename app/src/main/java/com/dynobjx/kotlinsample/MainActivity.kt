package com.dynobjx.kotlinsample

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.dynobjx.kotlinsample.adapters.PostAdapter
import com.dynobjx.kotlinsample.models.Post
import java.util.*

class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener,
        PostAdapter.OnClickItemListener {

    val rvPost: RecyclerView by bindView(R.id.rv_post)
    val swipeRefresh: SwipeRefreshLayout by bindView(R.id.swipe_refresh)

    private lateinit var adapter: PostAdapter
    private var posts: ArrayList<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //swipeRefresh.setOnRefreshListener(this)

        (1..100).mapTo(posts) { Post(it.toString(), it.toString(), it.toString(), "body : $it") }
        rvPost.setHasFixedSize(true)
        adapter = PostAdapter(this, posts, this)
        rvPost.adapter = adapter
    }

    override fun onClickItem(index: Int, post: Post) {
        val ss: Post = Post("130", "130", "130", "130")
        showToast((ss in posts).toString())
    }

    override fun onRefresh() {
        println("swipe to refresh action")
        showToast("swipe to refresh action")
    }
}
