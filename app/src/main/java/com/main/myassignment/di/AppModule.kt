
package com.main.myassignment.di

import com.main.myassignment.BuildConfig
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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ApiService = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: ApiService, dao: PostDao): PostRepository =
        PostRepositoryImpl(api, dao)
}
