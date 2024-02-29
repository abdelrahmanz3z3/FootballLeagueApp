package com.example.footballleagueapp.ui.competitions.viewmodel

import com.example.domain.model.CompetitionsItem
import com.example.footballleagueapp.common.SingleLiveEvent
import kotlinx.coroutines.flow.StateFlow

class CompetitionContract {

    interface ViewModel {
        fun invokeActions(action: Action)
        val state: StateFlow<State>
        val event: SingleLiveEvent<Event>
    }

    sealed class Action {
        data object LoadCompetition : Action()
        data class GotoDetailsActivity(val item: CompetitionsItem) : Action()
    }

    sealed class State {
        data object Loading : State()
        data class Success(val data: List<CompetitionsItem?>) : State()
        data class Error(val error: String) : State()
    }

    sealed class Event {
        data class CompetitionItemClicked(val item: CompetitionsItem) : Event()
    }
}