package com.main.myassignment.domain.repository

import com.main.myassignment.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<List<Post>>
    fun getFavorites(): Flow<List<Post>>
    suspend fun toggleFavorite(post: Post)
}
