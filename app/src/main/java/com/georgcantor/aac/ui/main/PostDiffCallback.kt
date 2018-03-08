package com.georgcantor.aac.ui.main

import android.support.v7.util.DiffUtil
import com.georgcantor.aac.data.local.entity.FakePost

/**
 * Created by Alex on 07.03.2018.
 *
 * checks the database and the data is not different it will not change it.
 */
class PostDiffCallback(var oldPostList: List<FakePost>, var newPostList: List<FakePost>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldPostList.size

    override fun getNewListSize(): Int = newPostList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldPostList[oldItemPosition].id == newPostList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldPostList[oldItemPosition].equals(newPostList[newItemPosition])
}