package com.marcosedu.movies.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.marcosedu.movies.MainDispatcherRule
import com.marcosedu.movies.domain.GetMoviesUseCase
import com.marcosedu.movies.domain.model.MovieDummy
import com.marcosedu.movies.presenter.model.ViewState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {
    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = MainDispatcherRule(StandardTestDispatcher())

    private lateinit var mainViewModel: MainViewModel

    private val getMoviesUseCase = mockk<GetMoviesUseCase>()

    @Before
    fun setup() {
        mainViewModel = MainViewModel(getMoviesUseCase, rule.dispatcher)
    }

    @Test
    fun `when getMoviesUseCase return success ViewState will be set as CONTENT`() = runTest {
        coEvery { getMoviesUseCase() } returns Result.success(MovieDummy.getListMovieDummy())
        mainViewModel.getMovies()
        advanceUntilIdle()
        Assert.assertNotNull(mainViewModel.movies.value)
     Assert.assertEquals(ViewState.CONTENT, mainViewModel.viewState.value)
    }

}