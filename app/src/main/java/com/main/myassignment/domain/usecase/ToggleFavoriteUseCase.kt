package com.main.myassignment.domain.usecase

import com.main.myassignment.data.local.entity.PostEntity
import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.repository.PostRepository
import javax.inject.Inject

class ToggleFavoriteUseCase@Inject constructor(private val repo: PostRepository) {
    suspend operator fun invoke(post: Post) {
        repo.toggleFavorite(post)
    }
}
