package com.example.calendartest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.calendartest.presentation.theme.Blurred

@Composable
fun LoaderIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Blurred)
            .pointerInput(null) {
                detectTapGestures {  } // need to block user scroll
            }
        ,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(all = 16.dp)
        ) {
            CircularProgressIndicator()
        }
    }
}