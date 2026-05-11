package com.main.myassignment.domain.usecase

import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PostUseCasesTest {
    private val fakeRepo = FakePostRepository()

    @Test
    fun getPosts_returnsRepositoryPosts() = runTest {
        val expected = listOf(Post(id = 1, userId = 1, title = "t", body = "b", isFavorite = false))
        fakeRepo.posts.value = expected

        val result = GetPostsUseCase(fakeRepo).invoke().first()
        assertEquals(expected, result)
    }

    @Test
    fun getFavorites_returnsRepositoryFavorites() = runTest {
        val expected = listOf(Post(id = 2, userId = 1, title = "f", body = "fav", isFavorite = true))
        fakeRepo.favorites.value = expected

        val result = GetFavoritesUseCase(fakeRepo).invoke().first()

        assertEquals(expected, result)
    }

    @Test
    fun toggleFavorite_callsRepositoryToggle() = runTest {
        val post = Post(id = 3, userId = 1, title = "x", body = "y", isFavorite = false)

        ToggleFavoriteUseCase(fakeRepo).invoke(post)

        assertEquals(post, fakeRepo.lastToggleArg)
    }
}

private class FakePostRepository : PostRepository {
    val posts = MutableStateFlow<List<Post>>(emptyList())
    val favorites = MutableStateFlow<List<Post>>(emptyList())
    var lastToggleArg: Post? = null

    override fun getPosts(): Flow<List<Post>> = posts
    override fun getFavorites(): Flow<List<Post>> = favorites

    override suspend fun toggleFavorite(post: Post) {
        lastToggleArg = post
    }
}
