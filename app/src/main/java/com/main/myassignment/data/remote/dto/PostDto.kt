package com.main.myassignment.data.remote.dto

data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val  image: String,
    val isFavorite: Boolean = false
)
