package com.debug.debugflix.data

import com.debug.debugflix.data.DiscoveryRepositoryImpl
import com.debug.debugflix.data.api.DiscoverAPI
import com.debug.debugflix.data.exception.DiscoveryRepositoryException
import com.debug.debugflix.data.model.BasePaginationRemote
import com.debug.debugflix.data.model.BasePaginationRemoteDummy
import com.debug.debugflix.data.model.MovieRemoteDummy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.Exception

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