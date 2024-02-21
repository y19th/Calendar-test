package com.example.calendartest.domain.models

import com.example.calendartest.R
import com.example.calendartest.util.Droppable

sealed class Countries(val code: String): Droppable {

    companion object {
        fun receiveAll() : List<Countries> {
            return listOf(Russia, Usa, Denmark, Japan)
        }

        fun find(value: String): Countries {
            return when(value) {
                "RU" -> {
                    Russia
                }
                "US" -> {
                    Usa
                }
                "DK" -> {
                    Denmark
                }
                "JP" -> {
                    Japan
                }
                else -> Unknown
            }
        }
    }

    data object Russia : Countries(code = "RU")

    data object Usa: Countries(code = "US")

    data object Denmark: Countries(code = "DK")

    data object Japan: Countries(code = "JP")

    data object Unknown: Countries(code = "")

    override fun stringId(): Int {
        return when(this) {
            Russia -> {
                R.string.country_russia
            }
            Usa -> {
                R.string.country_usa
            }
            Japan -> {
                R.string.country_japan
            }
            Denmark -> {
                R.string.country_denmark
            }

            else -> {
                R.string.country_unknown
            }
        }
    }



}