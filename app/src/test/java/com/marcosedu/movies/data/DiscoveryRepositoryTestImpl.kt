package com.marcosedu.movies.data

import com.marcosedu.movies.data.api.DiscoverAPI
import com.marcosedu.movies.data.exception.DiscoveryRepositoryException
import com.marcosedu.movies.data.model.BasePaginationRemoteDummy
import com.marcosedu.movies.data.model.MovieRemoteDummy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DiscoveryRepositoryTestImpl {
    private lateinit var discoveryRepositoryImpl: DiscoveryRepositoryImpl

    @MockK
    lateinit var discoveryService: DiscoverAPI

    @Before
    fun setup(){
        MockKAnnotations.init(this)

        discoveryRepositoryImpl = DiscoveryRepositoryImpl(discoveryService)
    }

    @Test
    fun `getMovies return sucess with a list of movies`() = runBlocking {
        coEvery { discoveryService.getMovies() } returns
                BasePaginationRemoteDummy.getBasePaginationDummy(
                    MovieRemoteDummy.getListMovieRemoteDummy()
                )

        val result = discoveryRepositoryImpl.getMovies()

        Assert.assertFalse(result.isEmpty())
    }

    @Test( expected = DiscoveryRepositoryException::class)
    fun `getMovies throws generic exception`() = runBlocking {
        coEvery { discoveryService.getMovies() } throws Exception()

        val result = discoveryRepositoryImpl.getMovies()
    }
}