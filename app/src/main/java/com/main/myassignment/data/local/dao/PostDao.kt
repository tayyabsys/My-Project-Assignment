package com.main.myassignment.data.local.dao

import androidx.room.*
import com.main.myassignment.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM PostEntity")
    fun getPosts(): Flow<List<PostEntity>>

    @Query("SELECT * FROM PostEntity WHERE isFavorite = 1")
    fun getFavorites(): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<PostEntity>)

    @Query("UPDATE PostEntity SET isFavorite = :fav WHERE id = :id")
    suspend fun updateFavorite(id: Int, fav: Boolean)


}
