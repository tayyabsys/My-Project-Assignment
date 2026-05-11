package com.main.myassignment.domain.usecase

import com.main.myassignment.domain.repository.PostRepository
import javax.inject.Inject


class GetPostsUseCase @Inject constructor(private val repo: PostRepository) {
    operator fun invoke() = repo.getPosts()
}
