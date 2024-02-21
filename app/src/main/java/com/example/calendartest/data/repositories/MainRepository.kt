package com.example.calendartest.data.repositories

import com.example.calendartest.data.api.MainApi
import com.example.calendartest.data.models.HolidayResponse
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val mainApi: MainApi
) {

    suspend fun receiveHolidays(
        year: Int,
        countryCode: String
    ): List<HolidayResponse>? {
        return mainApi.receiveHolidaysByYear(
            year = year,
            countryCode = countryCode
        ).body()
    }

}