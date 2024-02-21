package com.example.calendartest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.calendartest.R
import com.example.calendartest.domain.models.HolidayModel
import com.example.calendartest.util.extenstion.toIterableString

@Composable
internal fun CalendarItem(
    modifier: Modifier = Modifier,
    model: HolidayModel
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = stringResource(id = R.string.holiday_localname, model.localName),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            overflow = TextOverflow.Ellipsis
        )
        if(model.countries.isNotEmpty()) {
            Text(
                text = stringResource(
                    id = R.string.holiday_countries,
                    model.countries.toIterableString()
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        if(model.types.isNotEmpty()) {
            Text(
                text = stringResource(id = R.string.holiday_types, model.types.toIterableString()),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}