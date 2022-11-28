package com.marcosedu.movies.data

import com.marcosedu.movies.data.api.DiscoverAPI
import com.marcosedu.movies.data.exception.DiscoveryRepositoryException
import com.marcosedu.movies.data.model.toDomain
import com.marcosedu.movies.domain.model.Movie
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverAPI
) : DiscoveryRepository {

    override suspend fun getMovies(): List<Movie> {
        return try {
            discoverService.getMovies().results.map {
                it.toDomain()
            }
        } catch (ex: Exception){
            throw DiscoveryRepositoryException()
        }
    }
}