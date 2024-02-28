package com.example.data.common

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequestBuilder = chain.request().newBuilder()
            .addHeader("X-Auth-Token", Constants.apiToken)
        return chain.proceed(newRequestBuilder.build())
    }

}