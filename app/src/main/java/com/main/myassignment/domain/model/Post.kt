package com.main.myassignment.domain.model

data class Post(
    val id: Int,
    var userId: Int,
    val title: String,
    val body: String,
    val isFavorite: Boolean = false
)
