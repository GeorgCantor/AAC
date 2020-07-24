package com.georgcantor.aac.view.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain) =
            chain.proceed(chain.request().newBuilder().url(chain.request().url).build())
}
