package com.example.data.common

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequestBuilder = chain.request().newBuilder()
            .addHeader("X-Auth-Token", Constants.apiToken)
        if (hasNetwork(context)!!) {
            newRequestBuilder.header("Cache-Control", "public, max-age=" + 5)
        } else {
            newRequestBuilder.header(
                "Cache-Control",
                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
            )
        }
        return chain.proceed(newRequestBuilder.build())
    }

}