package com.main.myassignment.presentation.posts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPosts: GetPostsUseCase,
    private val getFavorites: GetFavoritesUseCase,
    private val toggleFavorite: ToggleFavoriteUseCase
) : ViewModel() {

    private val _posts = MutableStateFlow(UiState<List<Post>>(isLoading = true))
    val posts = _posts.asStateFlow()

    private val _favorites = MutableStateFlow(UiState<List<Post>>(isLoading = true))
    val favorites = _favorites.asStateFlow()

    init {
        loadPosts()
        loadFavorites()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            getPosts().collect {
                _posts.value = UiState(data = it)
            }
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            getFavorites().collect {
                _favorites.value = UiState(data = it)
            }
        }
    }

    fun onToggle(post: Post) {
        viewModelScope.launch {
            toggleFavorite(post)
        }
    }
}
