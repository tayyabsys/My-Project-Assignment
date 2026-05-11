package com.main.myassignment.presentation.post

import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.repository.PostRepository
import com.main.myassignment.domain.usecase.GetFavoritesUseCase
import com.main.myassignment.domain.usecase.GetPostsUseCase
import com.main.myassignment.domain.usecase.ToggleFavoriteUseCase
import com.main.myassignment.testutil.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Test
    fun toggle_whenSuccess_updatesFavoritesState() = runTest {
        val repo = FakePostRepository()
        val vm = createVm(repo)
        val post = Post(id = 10, userId = 1, title = "A", body = "B", isFavorite = false)

        vm.toggle(post)
        advanceUntilIdle()

        assertEquals(1, vm.favorites.value.size)
        assertEquals(10, vm.favorites.value.first().id)
    }

    @Test
    fun toggle_whenRepositoryFails_rollsBackFavoritesState() = runTest {
        val repo = FakePostRepository(shouldFailToggle = true)
        val vm = createVm(repo)
        val post = Post(id = 11, userId = 1, title = "A", body = "B", isFavorite = false)

        vm.toggle(post)
        advanceUntilIdle()

        assertEquals(emptyList<Post>(), vm.favorites.value)
    }

    private fun createVm(repo: FakePostRepository): PostViewModel {
        return PostViewModel(
            getPosts = GetPostsUseCase(repo),
            getFavorites = GetFavoritesUseCase(repo),
            toggleFavorite = ToggleFavoriteUseCase(repo)
        )
    }
}

private class FakePostRepository(
    private val shouldFailToggle: Boolean = false
) : PostRepository {
    private val posts = MutableStateFlow<List<Post>>(emptyList())
    private val favorites = MutableStateFlow<List<Post>>(emptyList())

    override fun getPosts(): Flow<List<Post>> = posts

    override fun getFavorites(): Flow<List<Post>> = favorites

    override suspend fun toggleFavorite(post: Post) {
        if (shouldFailToggle) error("toggle failed")
        favorites.value = if (post.isFavorite) {
            favorites.value.filterNot { it.id == post.id }
        } else {
            if (favorites.value.any { it.id == post.id }) favorites.value
            else listOf(post.copy(isFavorite = true)) + favorites.value
        }
    }
}
