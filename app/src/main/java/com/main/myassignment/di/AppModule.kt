
package com.example.mvvmapp.di

import com.main.myassignment.core.constants.ApiConstants
import com.main.myassignment.data.remote.api.ApiService
import com.main.myassignment.data.repository.PostRepositoryImpl
import com.main.myassignment.data.local.dao.PostDao
import com.main.myassignment.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(): ApiService =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    fun provideRepository(api: ApiService, dao: PostDao): PostRepository =
        PostRepositoryImpl(api, dao)
}
