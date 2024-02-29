package com.example.footballleagueapp.ui.competitions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultWrapper
import com.example.domain.usecase.GetCompetitionUseCase
import com.example.footballleagueapp.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val getCompetitionUseCase: GetCompetitionUseCase,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel(), CompetitionContract.ViewModel {

    override fun invokeActions(action: CompetitionContract.Action) {
        when (action) {
            is CompetitionContract.Action.GotoDetailsActivity -> {
                _event.postValue(CompetitionContract.Event.CompetitionItemClicked(action.item))
            }

            is CompetitionContract.Action.LoadCompetition -> {
                getCompetitions()
            }

        }
    }

    private val _state =
        MutableStateFlow<CompetitionContract.State>(CompetitionContract.State.Loading)
    override val state: StateFlow<CompetitionContract.State>
        get() = _state

    private val _event = SingleLiveEvent<CompetitionContract.Event>()
    override val event: SingleLiveEvent<CompetitionContract.Event>
        get() = _event

    private fun getCompetitions() {
        viewModelScope.launch(ioDispatcher) {
            val result = getCompetitionUseCase.invoke()
            result.collect { data ->
                when (data) {
                    is ResultWrapper.Error -> {
                        _state.emit(CompetitionContract.State.Error(data.error))
                    }

                    is ResultWrapper.Loading -> {
                        _state.emit(CompetitionContract.State.Loading)
                    }

                    is ResultWrapper.Success -> {
                        _state.emit(CompetitionContract.State.Success(data.data!!))
                    }
                }
            }
        }
    }
}