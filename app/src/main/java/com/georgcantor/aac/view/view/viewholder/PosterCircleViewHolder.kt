package com.georgcantor.aac.view.view.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.georgcantor.aac.databinding.ItemPosterCircleBinding
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.details.PosterDetailActivity
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

class PosterCircleViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var data: Article
    private val binding: ItemPosterCircleBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Article) {
            this.data = data
            drawItemUI()
        }
    }

    private fun drawItemUI() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.title)
            poster = data
            executePendingBindings()
        }
    }

    override fun onClick(view: View?) =
            PosterDetailActivity.startActivityModel(context(), binding.itemContainer, data)

    override fun onLongClick(view: View?) = false
}
