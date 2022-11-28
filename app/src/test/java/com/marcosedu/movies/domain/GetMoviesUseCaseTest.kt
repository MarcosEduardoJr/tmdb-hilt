package com.marcosedu.movies.domain

import com.marcosedu.movies.data.DiscoveryRepository
import com.marcosedu.movies.domain.model.MovieDummy
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetMoviesUseCaseTest {

    private lateinit var getMoviesUseCase: GetMoviesUseCase

    private val repository = mockk<DiscoveryRepository>()

    @Before
    fun setup() {
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