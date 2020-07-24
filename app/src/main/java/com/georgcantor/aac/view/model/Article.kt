package com.georgcantor.aac.view.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
        var title: String,
        var description: String,
        var url: String,
        var urlToImage: String?,
        var publishedAt: String,
        var content: String
) : Parcelable