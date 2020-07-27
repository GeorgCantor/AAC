package com.georgcantor.aac.view.view.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.georgcantor.aac.databinding.ItemArticleBinding
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.details.DetailActivity
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

class PosterViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var data: Article
    private val binding: ItemArticleBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Article) {
            this.data = data
            drawItemUi()
        }
    }

    private fun drawItemUi() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.title)
            poster = data
            executePendingBindings()
        }
    }

    override fun onClick(view: View?) =
            DetailActivity.startActivityModel(context(), binding.itemContainer, data)

    override fun onLongClick(view: View?) = false
}
