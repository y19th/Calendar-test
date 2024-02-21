package com.example.calendartest.data.api

import com.example.calendartest.data.models.HolidayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    @GET("/api/v3/publicholidays/{year}/{countryCode}")
    suspend fun receiveHolidaysByYear(
        @Path("year") year: Int,
        @Path("countryCode") countryCode: String
    ) : Response<List<HolidayResponse>>
}