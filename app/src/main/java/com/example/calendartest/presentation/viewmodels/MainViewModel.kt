package com.example.calendartest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendartest.domain.events.MainEvents
import com.example.calendartest.domain.states.MainState
import com.example.calendartest.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEvent(event: MainEvents) {
        when(event) {
            is MainEvents.OnRefresh -> {
                _state.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    mainUseCase.receiveHolidaysModels(
                        year = event.year,
                        countryCode = event.countryCode
                    )?.let { modelList ->
                        _state.update {
                            it.copy(
                                holidayList = modelList,
                                isLoading = false
                            )
                        }
                    }
                }
            }
            is MainEvents.OnYearChange -> {
                _state.update {
                    it.copy(yearNow = event.newValue)
                }
            }
            is MainEvents.OnCountryChange -> {
                _state.update {
                    it.copy(country = event.newValue)
                }
            }
        }
    }
}