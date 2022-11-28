package com.marcosedu.movies.network

import com.marcosedu.movies.BuildConfig
import com.marcosedu.movies.network.exception.NoNetworkConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class TmdbInterceptor(
    private val checkNetworkConnection: CheckNetworkConnection
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (checkNetworkConnection.isAvailable()) {
            val newUrl = chain.request().url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            return chain.proceed(
                chain.request().newBuilder()
                    .url(newUrl)
                    .build()
            )
        } else {
            throw NoNetworkConnectionException()
        }
    }
}
