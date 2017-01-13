package com.dynobjx.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.dynobjx.kotlinsample.R
import com.dynobjx.kotlinsample.models.Post
import java.util.ArrayList

/**
 * Created by root on 1/13/17.
 */
class PostAdapter constructor(context: Context, posts: ArrayList<Post>,
                              onclick: OnClickItemListener):
        RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var context: Context
    private var posts: ArrayList<Post>
    private var onItemClick: OnClickItemListener

    init {
        println("init block!")
        this.context = context
        this.posts = posts
        this.onItemClick = onclick
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post: Post = this.posts.get(position)
        holder.tvTitle.text = post.title
        holder.tvBody.text = post.body
        holder.itemView.setOnClickListener { onItemClick.onClickItem(position, post) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))

    class ViewHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView by bindView(R.id.tvTitle)
        val tvBody: TextView by bindView(R.id.tvBody)
    }

    interface OnClickItemListener {
        fun onClickItem(index: Int, post: Post)
    }
}