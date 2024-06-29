package com.example.rickyapp.ui.utils


sealed class Resource<out R> {

    data class Success<out R>(val result: R): Resource<R>()

    data class Error(val exception: Exception): Resource<Nothing>()

}


sealed class UIState {

    data object Loading: UIState()

    data object Empty: UIState()

    data class Loaded<out R>(val result: R): UIState()

    data class Error(val exception: Exception): UIState()

}