package com.georgcantor.aac.view.model

data class News(
    var status: String,
    var totalResults: Int,
    var articles: List<Article>
)
