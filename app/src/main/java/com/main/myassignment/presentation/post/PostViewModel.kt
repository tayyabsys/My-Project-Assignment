package com.main.myassignment.presentation.post

import androidx.lifecycle.viewModelScope
import com.main.myassignment.core.base.BaseViewModel
import com.main.myassignment.core.util.UiState
import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.usecase.GetFavoritesUseCase
import com.main.myassignment.domain.usecase.GetPostsUseCase
import com.main.myassignment.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel@Inject constructor(
    private val getPosts: GetPostsUseCase,
    private val getFavorites: GetFavoritesUseCase,
    private val toggleFavorite: ToggleFavoriteUseCase
) : BaseViewModel() {
    val posts = getPosts()
        .map { list ->
            UiState.Success(list) as UiState<List<Post>>
        }
        .onStart {
            emit(UiState.Loading)
        }
        .catch { e ->
            emit(UiState.Error(e.message ?: "Something went wrong"))
        }
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            UiState.Loading
        )

    val favorites = getFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggle(post: Post) {
        viewModelScope.launch {
            toggleFavorite(post)
        }
    }
}
