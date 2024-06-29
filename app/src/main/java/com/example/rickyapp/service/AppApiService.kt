package com.example.rickyapp.service

import com.example.rickyapp.model.CharacterData
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface AppApiService {

    @GET("/api/character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1
    ) : CharacterData
}