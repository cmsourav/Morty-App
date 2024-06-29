package com.example.rickyapp.di

import com.example.rickyapp.repository.Repository
import com.example.rickyapp.repository.RepositoryImpl
import com.example.rickyapp.service.AppApiService
import com.example.rickyapp.service.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(): AppApiService =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(
        apiService: AppApiService
    ) : Repository {
        return RepositoryImpl(apiService)
    }
}