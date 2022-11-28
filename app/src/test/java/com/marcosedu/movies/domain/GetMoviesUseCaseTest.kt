package com.marcosedu.movies.domain

import com.marcosedu.movies.data.DiscoveryRepository
import com.marcosedu.movies.data.DiscoveryRepositoryImpl
import com.marcosedu.movies.data.api.DiscoverAPI
import com.marcosedu.movies.data.exception.DiscoveryRepositoryException
import com.marcosedu.movies.data.model.BasePaginationRemote
import com.marcosedu.movies.data.model.BasePaginationRemoteDummy
import com.marcosedu.movies.data.model.MovieRemoteDummy
import com.marcosedu.movies.domain.model.MovieDummy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class GetMoviesUseCaseTest {

    private lateinit var getMoviesUseCase: GetMoviesUseCase

    private val repository = mockk<DiscoveryRepository>()

    @Before
    fun setup(){
        getMoviesUseCase = GetMoviesUseCase(repository)
    }

    @Test
    fun `when getMovies return sucess with a list of movies`() = runBlocking {
        coEvery { repository.getMovies() } returns MovieDummy.getListMovieDummy()

        val result = getMoviesUseCase()

        Assert.assertTrue(result.isSuccess)
    }

    @Test
    fun `when getMovies throws generic exception`() = runBlocking {
        coEvery { repository.getMovies() } throws Exception()

        val result = getMoviesUseCase()

        Assert.assertTrue(result.isFailure)
    }
}