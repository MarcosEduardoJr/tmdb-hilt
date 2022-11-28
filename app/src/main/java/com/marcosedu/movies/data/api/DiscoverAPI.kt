package com.marcosedu.movies.data.api

import com.marcosedu.movies.data.model.BasePaginationRemote
import com.marcosedu.movies.data.model.MovieRemote
import retrofit2.http.GET

interface DiscoverAPI {

    @GET("discover/movie")
    suspend fun getMovies(): BasePaginationRemote<List<MovieRemote>>
}