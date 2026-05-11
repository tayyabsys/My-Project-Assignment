package com.main.myassignment.data.remote.api

import com.main.myassignment.data.remote.dto.PostDto
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
