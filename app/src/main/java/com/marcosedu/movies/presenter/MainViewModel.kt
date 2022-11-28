package com.marcosedu.movies.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosedu.movies.di.DispatcherIo
import com.marcosedu.movies.domain.GetMoviesUseCase
import com.marcosedu.movies.presenter.model.MovieViewObject
import com.marcosedu.movies.presenter.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @DispatcherIo private val dispatcher : CoroutineDispatcher
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieViewObject>>()
    val movies: LiveData<List<MovieViewObject>> = _movies

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun getMovies() {
        _viewState.postValue(ViewState.LOADING)

        viewModelScope.launch(dispatcher) {
            getMoviesUseCase().onSuccess { movies ->
                _movies.postValue(movies.map { movie ->
                    MovieViewObject(movie)
                })

             _viewState.postValue(ViewState.CONTENT)
            }.onFailure {
              _viewState.postValue(ViewState.ERROR)
            }
        }
    }
}