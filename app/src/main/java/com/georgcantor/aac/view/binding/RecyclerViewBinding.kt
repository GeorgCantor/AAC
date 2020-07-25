package com.georgcantor.aac.view.binding

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.adapter.ArticleAdapter
import com.georgcantor.aac.view.view.adapter.ArticleCircleAdapter
import com.georgcantor.aac.view.view.adapter.ArticleLineAdapter
import com.skydoves.baserecyclerviewadapter.BaseAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: LiveData<String>) {
    text.value?.let { Toast.makeText(view.context, it, LENGTH_SHORT).show() }
}

@BindingAdapter("adapterPosterList")
fun bindAdapterPosterList(view: RecyclerView, posters: List<Article>?) {
    posters?.let { (view.adapter as? ArticleAdapter)?.addPosterList(it) }
}

@BindingAdapter("adapterPosterLineList")
fun bindAdapterPosterLineList(view: RecyclerView, posters: List<Article>?) {
    posters?.let { (view.adapter as? ArticleLineAdapter)?.addPosterList(it) }
}

@BindingAdapter("adapterPosterCircleList")
fun bindAdapterPosterCircleList(view: RecyclerView, posters: List<Article>?) {
    posters?.let { (view.adapter as? ArticleCircleAdapter)?.addPosterList(it) }
}
