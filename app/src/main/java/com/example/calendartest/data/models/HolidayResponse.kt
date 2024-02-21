package com.example.calendartest.data.models

import com.google.gson.annotations.SerializedName

data class HolidayResponse(
    @SerializedName("date") val date: String = "",
    @SerializedName("localName") val localName: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("countryCode") val countryCode: String = "",
    @SerializedName("fixed") val fixed: Boolean = false,
    @SerializedName("global") val global: Boolean = false,
    @SerializedName("countries") val countries: List<String> = listOf(),
    @SerializedName("launchYear") val launchYear: Int = 0,
    @SerializedName("types") val types: List<String> = listOf()
)
