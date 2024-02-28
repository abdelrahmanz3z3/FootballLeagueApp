package com.example.footballleagueapp.datasource.common

sealed class ResultWrapper<out T> {
    data object Loading : ResultWrapper<Nothing>()
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error(val error: String) : ResultWrapper<Nothing>()
}