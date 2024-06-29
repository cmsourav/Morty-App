package com.example.rickyapp.repository

import com.example.rickyapp.model.CharacterData
import com.example.rickyapp.ui.utils.Resource

interface Repository {

    suspend fun getCharacterList(page: Int): Resource<CharacterData>
}