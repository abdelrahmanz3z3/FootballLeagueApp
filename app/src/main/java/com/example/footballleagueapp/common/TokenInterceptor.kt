package com.example.footballleagueapp.common

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequestBuilder = chain.request().newBuilder()

        newRequestBuilder.addHeader("X-Auth-Token", "6fdc589768e8481db9823c6c7e84f369")

        return chain.proceed(newRequestBuilder.build())
    }
}