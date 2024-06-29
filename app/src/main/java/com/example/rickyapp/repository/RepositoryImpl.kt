package com.example.rickyapp.repository

import com.example.rickyapp.model.CharacterData
import com.example.rickyapp.service.AppApiService
import com.example.rickyapp.ui.utils.Resource

class RepositoryImpl(
    private val apiService: AppApiService,
) : Repository {

    override suspend fun getCharacterList(page: Int): Resource<CharacterData> =
        try {
            val response = apiService.getCharacters(page)
            Resource.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e)
        }
}