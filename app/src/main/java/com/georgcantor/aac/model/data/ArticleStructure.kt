package com.georgcantor.aac.model.data

data class ArticleStructure(
        var source: Source? = null,
        var author: String? = null,
        var title: String? = null,
        var description: String? = null,
        var url: String? = null,
        var urlToImage: String? = null,
        var publishedAt: String? = null
)


