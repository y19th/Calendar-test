package com.example.calendartest.domain.events

import com.example.calendartest.domain.models.Countries

sealed interface MainEvents {

    data class OnRefresh(val year: Int, val countryCode: String): MainEvents

    data class OnYearChange(val newValue: Int) : MainEvents

    data class OnCountryChange(val newValue: Countries) : MainEvents
}