package com.debug.debugflix.domain.model

import kotlin.random.Random

object MovieDummy {

    fun getListMovieDummy() = listOf(getMovieDummy())

    private fun getMovieDummy() = Movie(
        adult = Random.nextBoolean(),
        backdropPath = "path",
        genreIds = listOf(),
        id = Random.nextInt(),
        originalLanguage = "",
        originalTitle = "",
        overview = "",
        popularity = Random.nextDouble(),
        posterPath = "",
        releaseDate = "",
        title = "",
        video = Random.nextBoolean(),
        voteAverage = Random.nextDouble(),
        voteCount = Random.nextInt()
    )
}