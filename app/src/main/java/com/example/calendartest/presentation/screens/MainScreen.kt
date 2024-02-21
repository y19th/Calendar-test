package com.example.calendartest.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calendartest.R
import com.example.calendartest.domain.events.MainEvents
import com.example.calendartest.domain.models.Countries
import com.example.calendartest.presentation.components.CalendarDropDown
import com.example.calendartest.presentation.components.CalendarHeader
import com.example.calendartest.presentation.components.CalendarRow
import com.example.calendartest.presentation.components.LoaderIndicator
import com.example.calendartest.presentation.components.VerticalSpacer
import com.example.calendartest.presentation.viewmodels.MainViewModel
import java.time.LocalDate

@PreviewScreenSizes
@PreviewLightDark
@Composable
fun PreviewMainScreen() {
    MainScreen()
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    val dateList = rememberDateList(state.yearNow)
    val dropYears = rememberYears()


    LaunchedEffect(state.yearNow, state.country) {
        viewModel.onEvent(
            MainEvents.OnRefresh(
                year = state.yearNow,
                countryCode = state.country.code
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.main_screen_title),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Divider()

            VerticalSpacer(height = 16.dp)

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                CalendarDropDown(
                    label = stringResource(
                        id = R.string.country_now,
                        stringResource(id = state.country.stringId())
                    ),
                    dropDownItems = Countries.receiveAll(),
                    onDropDownClick = {
                        viewModel.onEvent(MainEvents.OnCountryChange(newValue = it))
                    }
                )
                CalendarDropDown(
                    label = stringResource(id = R.string.year_now, state.yearNow),
                    dropDownItems = dropYears,
                    onDropDownClick = {
                        viewModel.onEvent(MainEvents.OnYearChange(newValue = it))
                    }
                )
            }


            VerticalSpacer(height = 32.dp)

            Text(
                text = stringResource(
                    id = R.string.main_screen_days_count,
                    dateList.size
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.Start)
            )

            VerticalSpacer(height = 4.dp)

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                stickyHeader {
                    CalendarHeader(
                        leftText = stringResource(id = R.string.header_date),
                        rightText = stringResource(id = R.string.header_holiday)
                    )
                }
                items(
                    items = dateList
                ) {
                    CalendarRow(
                        leftText = it,
                        model = state.holidayList.find { model -> model.date == it }
                    )
                }
            }
        }

        if(state.isLoading) LoaderIndicator()
    }
}


@Composable
private fun rememberDateList(yearNow: Int): List<String> {

    val dateList = mutableListOf<String>()
    val dayCount = if (yearNow % 4 == 0) 366 else 365

    for (day in 1..dayCount) {
        dateList.add(LocalDate.ofYearDay(yearNow, day).toString())
    }

    return remember(yearNow) {
        dateList
    }
}

@Composable
private fun rememberYears(): List<Int> {
    return remember {
        val now = LocalDate.now().year
        listOf(
            now,
            now - 1,
            now - 2,
            now - 3,
            now - 4
        )
    }
}






