package com.marcosedu.movies.presenter.model

import com.marcosedu.movies.domain.model.Movie

data class MovieViewObject(
    val name: String,
    val poster: String
) {
    constructor(movie: Movie) : this(
        name = movie.title.orEmpty(),
        poster = movie.posterPath.orEmpty()
    )
}

