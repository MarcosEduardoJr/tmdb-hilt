package com.marcosedu.movies.domain

import com.marcosedu.movies.data.DiscoveryRepository
import com.marcosedu.movies.domain.model.Movie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: DiscoveryRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return try {
            Result.success(repository.getMovies())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}