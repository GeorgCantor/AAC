package com.georgcantor.aac.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.georgcantor.aac.model.data.NewsResponse
import com.georgcantor.aac.viewmodel.MainViewModel

class NewsFragment : Fragment() {

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
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        viewModel.getNews(source).observe(viewLifecycleOwner, Observer<NewsResponse> { news ->
            if (news != null) {

            }
        })
    }

//    private fun observeViewModel(viewModel: MainViewModel) {
//        viewModel.getCatsLiveData().observe(viewLifecycleOwner, Observer<Any> { cats ->
//            if (cats != null) {
//                recyclerView.setAdapter(adapter)
//                adapter.setList(cats)
//            }
//        })
//    }
}