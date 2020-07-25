package com.georgcantor.aac.view.view.adapter

import android.view.View
import com.georgcantor.aac.R
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.viewholder.PosterViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class ArticleAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Article>())
    }

    fun addPosterList(posters: List<Article>) {
        sections().first().run {
            clear()
            addAll(posters)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = PosterViewHolder(view)
}
