package ru.dradefire.examplemvi

sealed interface UserIntent {
    data object KekClick : UserIntent
    data object LolClick : UserIntent
}