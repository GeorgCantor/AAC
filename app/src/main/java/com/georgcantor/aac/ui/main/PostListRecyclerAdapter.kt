package com.georgcantor.aac.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.georgcantor.aac.data.local.entity.FakePost
import com.georgcantor.aac.databinding.ItemPostBinding

/**
 * Created by Alex on 08.03.2018.
 */
class PostListRecyclerAdapter(var callback: PostCallback)
    : RecyclerView.Adapter<PostListRecyclerAdapter.PostViewHolder>() {

    private var postList: ArrayList<FakePost> = ArrayList()

    fun setData(posts: List<FakePost>) {
        val diffCallback = DiffUtil.calculateDiff(PostDiffCallback(postList, posts))
        with(postList) { clear(); addAll(posts) }
        diffCallback.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder =
            PostViewHolder.create(LayoutInflater.from(parent?.context), parent, callback)

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.onBind(post)
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(val itemPostBinding: ItemPostBinding, val callback: PostCallback)
        : RecyclerView.ViewHolder(itemPostBinding.root) {

        companion object {
            fun create(layoutInflater: LayoutInflater, parent: ViewGroup?, callback: PostCallback): PostViewHolder {
                val itemPostBinding = ItemPostBinding.inflate(layoutInflater, parent, false)
                return PostViewHolder(itemPostBinding, callback)
            }
        }

        init {
            itemPostBinding.root.setOnClickListener {
                callback.let { callback.onPostClick(itemPostBinding.post) }
            }
        }

        fun onBind(posts: FakePost) {
            itemPostBinding.apply {
                post = posts
                executePendingBindings()
            }
        }
    }
}