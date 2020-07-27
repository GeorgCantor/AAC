package com.georgcantor.aac.view.view.adapter

import android.view.View
import com.georgcantor.aac.R
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.viewholder.PosterLineViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class ArticleLineAdapter : BaseAdapter() {

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

    override fun layout(sectionRow: SectionRow) = R.layout.item_article_line

    override fun viewHolder(layout: Int, view: View) = PosterLineViewHolder(view)
}
