package com.georgcantor.aac.ui.main

import com.georgcantor.aac.data.local.entity.FakePost

/**
 * Created by Alex on 07.03.2018.
 *
 * post on click event
 */
interface PostCallback {

    fun onPostClick(posts: FakePost?)
}