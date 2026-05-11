package com.main.myassignment.presentation.post

import androidx.lifecycle.viewModelScope
import com.main.myassignment.core.base.BaseViewModel
import com.main.myassignment.core.util.UiState
import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.usecase.GetFavoritesUseCase
import com.main.myassignment.domain.usecase.GetPostsUseCase
import com.main.myassignment.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel@Inject constructor(
    getPosts: GetPostsUseCase,
    private val getFavorites: GetFavoritesUseCase,
    private val toggleFavorite: ToggleFavoriteUseCase
) : BaseViewModel() {
    private val _favorites = MutableStateFlow<List<Post>>(emptyList())
    val favorites: StateFlow<List<Post>> = _favorites.asStateFlow()

    init {
        observeFavorites()
    }

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

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavorites().collectLatest { latest ->
                _favorites.value = latest
            }
        }
    }

    fun toggle(post: Post) {
        viewModelScope.launch {
            val previous = _favorites.value
            _favorites.update { current ->
                if (post.isFavorite) {
                    current.filterNot { it.id == post.id }
                } else {
                    if (current.any { it.id == post.id }) current
                    else listOf(post.copy(isFavorite = true)) + current
                }
            }
            try {
                toggleFavorite(post)
            } catch (_: Exception) {
                _favorites.value = previous
            }
        }
    }
}
