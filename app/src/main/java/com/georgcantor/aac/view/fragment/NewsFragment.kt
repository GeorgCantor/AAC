package com.georgcantor.aac.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.aac.R
import com.georgcantor.aac.model.data.NewsResponse
import com.georgcantor.aac.view.adapter.NewsAdapter
import com.georgcantor.aac.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private lateinit var adapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var source: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            source = bundle.getString("source") ?: ""
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerView = newsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        viewModel.getNews(source).observe(viewLifecycleOwner, Observer<NewsResponse> { news ->
            if (news != null) {
                recyclerView.adapter = adapter
                adapter.setNews(news)
            }
        })
    }
}