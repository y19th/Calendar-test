package com.example.calendartest.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.calendartest.R
import com.example.calendartest.domain.models.HolidayModel

@Composable
internal fun CalendarRow(
    modifier: Modifier = Modifier,
    leftText: String = "",
    model: HolidayModel? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .then(modifier)
    ) {
        Text(
            text = leftText,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .border(
                    color = Color.Black,
                    width = 1.dp
                )
                .fillMaxHeight()
                .weight(0.3f)
                .padding(all = 4.dp)
        )
        if(model != null) {
            CalendarItem(
                modifier = Modifier
                    .border(
                        color = Color.Black,
                        width = 1.dp
                    )
                    .weight(0.7f)
                    .padding(all = 4.dp),
                model = model
            )
        } else {
            Text(
                text = stringResource(id = R.string.no_holiday),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .border(
                        color = Color.Black,
                        width = 1.dp
                    )
                    .weight(0.7f)
                    .padding(all = 4.dp),
            )
        }

    }

}