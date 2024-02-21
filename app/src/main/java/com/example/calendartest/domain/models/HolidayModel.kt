package com.example.calendartest.domain.models

import com.example.calendartest.data.models.HolidayResponse

data class HolidayModel(
   val date: String = "",
   val localName: String = "",
   val name: String = "",
   val countryCode: String = "",
   val fixed: Boolean = false,
   val global: Boolean = false,
   val countries: List<String> = listOf(),
   val launchYear: Int = 0,
   val types: List<String> = listOf()
)

fun HolidayResponse.toHolidayModel() = HolidayModel(
    date, localName, name, countryCode, fixed, global, countries, launchYear, types
)