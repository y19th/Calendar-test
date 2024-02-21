package com.example.calendartest.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.calendartest.util.Droppable


@JvmName("DroppableCalendarDropDown")
@Composable
fun <T: Droppable> CalendarDropDown(
    label: String,
    dropDownItems: List<T>,
    onDropDownClick: (T) -> Unit
) {
    var exposed by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .clickable {
                    exposed = exposed.not()
                }
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        DropdownMenu(
            expanded = exposed,
            onDismissRequest = { exposed = false }
        ) {
            repeat(dropDownItems.size) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(id = dropDownItems[it].stringId())
                        )
                    },
                    onClick = {
                        onDropDownClick.invoke(dropDownItems[it])
                        exposed = false
                    }
                )
            }
        }
    }
}

@JvmName("CalendarDropDown")
@Composable
fun <T> CalendarDropDown(
    label: String,
    dropDownItems: List<T>,
    onDropDownClick: (T) -> Unit
) {
    var exposed by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .clickable {
                    exposed = exposed.not()
                }
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        DropdownMenu(
            expanded = exposed,
            onDismissRequest = { exposed = false }
        ) {
            repeat(dropDownItems.size) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = dropDownItems[it].toString()
                        )
                    },
                    onClick = {
                        onDropDownClick.invoke(dropDownItems[it])
                        exposed = false
                    }
                )
            }
        }
    }
}


