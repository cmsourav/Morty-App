package com.example.rickyapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickyapp.model.Result
import com.example.rickyapp.repository.Repository
import com.example.rickyapp.ui.utils.Resource
import com.example.rickyapp.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Empty)
    val uiState: StateFlow<UIState> = _uiState

    var sharedResult: MutableState<Result?> = mutableStateOf(null)

    fun getDataFromRepo() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.getCharacterList(20)) {
                is Resource.Success -> {
                    _uiState.value = UIState.Loading
//                    delay(300)
                    response.result.let { data ->
                        _uiState.value = UIState.Loaded(data)
                    }
                }

                is Resource.Error -> {
                    _uiState.value = UIState.Error(exception = response.exception)
                }
            }
        }
    }
}