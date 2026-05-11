package com.main.myassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val userId: Int,
    val description: String,
    val isFavorite: Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)
