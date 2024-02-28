package com.example.footballleagueapp.datasource.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Flow<ResultWrapper<T>> = flow {
    emit(ResultWrapper.Loading)
    val result = apiCall.invoke()
    emit(ResultWrapper.Success(result))
}.catch {
    emit(ResultWrapper.Error(it.localizedMessage!!))

}