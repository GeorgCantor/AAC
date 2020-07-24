package com.georgcantor.aac.view.view.adapter

import android.view.View
import com.georgcantor.aac.R
import com.georgcantor.aac.view.model.Poster
import com.georgcantor.aac.view.view.viewholder.PosterCircleViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class PosterCircleAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Poster>())
    }

    fun addPosterList(posters: List<Poster>) {
        sections().first().run {
            clear()
            addAll(posters)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster_circle

    override fun viewHolder(layout: Int, view: View) = PosterCircleViewHolder(view)
}
