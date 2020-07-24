package com.georgcantor.aac.view.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.view.adapter.PosterAdapter
import com.georgcantor.aac.view.view.adapter.PosterCircleAdapter
import com.georgcantor.aac.view.view.adapter.PosterLineAdapter
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: LiveData<String>) {
    text.value.whatIfNotNull {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("adapterPosterList")
fun bindAdapterPosterList(view: RecyclerView, posters: List<Article>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterLineList")
fun bindAdapterPosterLineList(view: RecyclerView, posters: List<Article>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterLineAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterCircleList")
fun bindAdapterPosterCircleList(view: RecyclerView, posters: List<Article>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterCircleAdapter)?.addPosterList(it)
    }
}
