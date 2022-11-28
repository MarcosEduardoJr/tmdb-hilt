package com.debug.debugflix.data.model

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

object HttpExceptionDummy {
    fun getNotFound() =
        Response.error<String>(404,
        "".toResponseBody("application/json".toMediaTypeOrNull()))
}