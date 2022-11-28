package com.debug.debugflix.data.model

import kotlin.random.Random

object MovieRemoteDummy {

    fun getListMovieRemoteDummy() = listOf(getMovieRemoteDummy())

    private fun getMovieRemoteDummy() = MovieRemote(
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