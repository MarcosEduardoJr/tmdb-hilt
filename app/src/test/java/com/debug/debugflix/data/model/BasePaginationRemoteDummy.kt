package com.debug.debugflix.data.model

import kotlin.random.Random

object BasePaginationRemoteDummy {
    fun <T> getBasePaginationDummy(result: T) = BasePaginationRemote(
        page = Random.nextInt(),
        results = result,
        totalPages = Random.nextInt(),
        totalResults = Random.nextInt()
    )
}