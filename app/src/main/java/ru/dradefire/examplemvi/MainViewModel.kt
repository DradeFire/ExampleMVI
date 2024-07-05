package ru.dradefire.examplemvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun sendUserIntent(userIntent: UserIntent) {
        when (userIntent) {
            UserIntent.KekClick -> onKekClick()
            UserIntent.LolClick -> onLolClick()
        }
    }

    private fun onKekClick() {
        _state.update {
            it.copy(
                title = "MegaKek",
                subTitle = "SuperKek",
                text = "Kek",
            )
        }
    }

    private fun onLolClick() {
        _state.update {
            it.copy(
                title = "MegaLol",
                subTitle = "SuperLol",
                text = "Lol",
            )
        }
    }
}