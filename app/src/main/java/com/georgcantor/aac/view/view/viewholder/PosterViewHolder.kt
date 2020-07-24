package com.georgcantor.aac.view.view.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.georgcantor.aac.databinding.ItemPosterBinding
import com.georgcantor.aac.view.model.Poster
import com.georgcantor.aac.view.view.details.PosterDetailActivity
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

class PosterViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var data: Poster
    private val binding: ItemPosterBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Poster) {
            this.data = data
            drawItemUi()
        }
    }

    private fun drawItemUi() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.name)
            poster = data
            executePendingBindings()
        }
    }

    override fun onClick(view: View?) =
            PosterDetailActivity.startActivityModel(context(), binding.itemContainer, data)

    override fun onLongClick(view: View?) = false
}
