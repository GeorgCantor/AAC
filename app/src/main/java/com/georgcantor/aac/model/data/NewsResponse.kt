package com.georgcantor.aac.model.data

import java.util.*

data class NewsResponse(
        var status: String? = null,
        var totalResults: Int = 0,
        var articles: ArrayList<ArticleStructure>? = null
)


