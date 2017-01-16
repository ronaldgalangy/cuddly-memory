package com.dynobjx.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dynobjx.kotlinsample.R
import com.dynobjx.kotlinsample.models.Post
import kotlinx.android.synthetic.main.post_item.view.*

/**
 * Created by root on 1/13/17.
 */
class PostAdapter constructor(val context: Context, var posts: MutableList<Post>,
                              val itemClick: (Post) -> Unit):
        RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(posts[position]) {
            holder.itemView.tvTitle.text = title
            holder.itemView.tvBody.text = body
            holder.itemView.setOnClickListener { itemClick.invoke(this) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)=
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false),
    itemClick)

    class ViewHolder constructor(itemView: View?, val itemClick: (Post) -> Unit):
            RecyclerView.ViewHolder(itemView) {
        fun bindToView(post: Post) {
            with(post) {
                itemView.tvTitle.text = title
                itemView.tvBody.text = body
                itemView.setOnClickListener { itemClick.invoke(this) }
            }
        }
    }
}