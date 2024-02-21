package com.example.calendartest.domain.states

import com.example.calendartest.domain.models.Countries
import com.example.calendartest.domain.models.HolidayModel
import java.time.LocalDate
import java.util.Locale

data class MainState(
    val holidayList: List<HolidayModel> = listOf(),
    val yearNow: Int = LocalDate.now().year,
    val country: Countries = Countries.find(Locale.getDefault().country),

    val isLoading: Boolean = true
)