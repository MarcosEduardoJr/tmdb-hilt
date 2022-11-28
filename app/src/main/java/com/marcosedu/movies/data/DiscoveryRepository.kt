package com.marcosedu.movies.data

import com.marcosedu.movies.domain.model.Movie

interface DiscoveryRepository {

    suspend fun getMovies(): List<Movie>
}