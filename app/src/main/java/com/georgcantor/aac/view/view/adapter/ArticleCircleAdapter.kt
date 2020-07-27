package com.georgcantor.aac.view.view.adapter

import android.view.View
import com.georgcantor.aac.R
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.viewholder.PosterCircleViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class ArticleCircleAdapter : BaseAdapter() {

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

    override fun layout(sectionRow: SectionRow) = R.layout.item_article_circle

    override fun viewHolder(layout: Int, view: View) = PosterCircleViewHolder(view)
}
