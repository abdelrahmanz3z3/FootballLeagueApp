package com.example.footballleagueapp.ui.competition.viewmodel

import com.example.footballleagueapp.common.SingleLiveEvent
import com.example.footballleagueapp.repositry.model.CompetitionsItem
import kotlinx.coroutines.flow.StateFlow

class CompetitionContract {

    interface ViewModel {
        fun invokeActions(action: Action)
        val state: StateFlow<State>
        val event: SingleLiveEvent<State>
    }

    sealed class Action {
        data object LoadCompetition : Action()
        data object GotoDetailsActivity : Action()
    }

    sealed class State {
        data object Loading : State()
        data class Success(val data: List<CompetitionsItem?>) : State()
        data class Error(val error: String) : State()
    }

    sealed class Event {
        data object CompetitionItemClicked : Event()
    }
}