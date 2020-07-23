package com.georgcantor.aac.view.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
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
fun bindAdapterPosterList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterLineList")
fun bindAdapterPosterLineList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterLineAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterCircleList")
fun bindAdapterPosterCircleList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterCircleAdapter)?.addPosterList(it)
    }
}
