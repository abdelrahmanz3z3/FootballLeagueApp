package com.example.footballleagueapp.ui.competition.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballleagueapp.common.SingleLiveEvent
import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.repositry.contract.CompetitionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(private val competitionRepository: CompetitionRepository) :
    ViewModel(), CompetitionContract.ViewModel {

    override fun invokeActions(action: CompetitionContract.Action) {
        when (action) {
            is CompetitionContract.Action.GotoDetailsActivity -> {}
            is CompetitionContract.Action.LoadCompetition -> {
                getCompetitions()
            }

        }
    }

    private val _state =
        MutableStateFlow<CompetitionContract.State>(CompetitionContract.State.Loading)
    override val state: StateFlow<CompetitionContract.State>
        get() = _state
    override val event: SingleLiveEvent<CompetitionContract.State>
        get() = TODO("Not yet implemented")

    private fun getCompetitions() {
        viewModelScope.launch {
            val result = competitionRepository.getCompetition()
            result.collect { data ->
                when (data) {
                    is ResultWrapper.Error -> {
                        _state.emit(CompetitionContract.State.Error(data.error))
                    }

                    is ResultWrapper.Loading -> {
                        _state.emit(CompetitionContract.State.Loading)
                    }

                    is ResultWrapper.Success -> {
                        _state.emit(CompetitionContract.State.Success(data.data.competitions!!))
                    }
                }
            }
        }
    }
}