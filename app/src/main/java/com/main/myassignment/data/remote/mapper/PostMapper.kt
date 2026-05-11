package com.main.myassignment.data.remote.mapper

import com.main.myassignment.data.local.entity.PostEntity
import com.main.myassignment.data.remote.dto.PostDto
import com.main.myassignment.domain.model.Post

fun PostDto.toEntity(): PostEntity {
    return PostEntity(
        id = id,
        userId = userId,
        title = title,
        description = body,
        isFavorite = isFavorite
    )
}

fun PostEntity.toDomain() = Post(id, userId,title, description,isFavorite)
