package com.main.myassignment.data.repository

import com.main.myassignment.data.local.dao.PostDao
import com.main.myassignment.data.remote.api.ApiService
import com.main.myassignment.data.remote.mapper.toDomain
import com.main.myassignment.data.remote.mapper.toEntity
import com.main.myassignment.domain.model.Post
import com.main.myassignment.domain.repository.PostRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: PostDao
) : PostRepository {

    override fun getPosts(): Flow<List<Post>> {
        return dao.getPosts()
            .map { entities ->
                entities.map { it.toDomain() }
            }
            .onStart {
                val local = dao.getPosts().first()

                if (local.isEmpty()) {
                    val remote = api.getPosts()

                    dao.insertAll(
                        remote.map { dto ->
                            dto.toEntity()
                        }
                    )
                }
            }
    }


    override suspend fun toggleFavorite(post: Post) {
        dao.updateFavorite(
            id = post.id,
            fav = !post.isFavorite,
        )
    }

    override fun getFavorites(): Flow<List<Post>> {
        return dao.getFavorites()
            .map { list -> list.map { it.toDomain() } }


    }


}

