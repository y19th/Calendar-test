package com.example.calendartest.domain.usecase

import android.util.Log
import com.example.calendartest.data.repositories.MainRepository
import com.example.calendartest.domain.models.toHolidayModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val coreContext = defaultDispatcher + Handler.coroutineExceptionHandler

    suspend fun receiveHolidaysModels(
        year: Int,
        countryCode: String
    ) = withContext(coreContext) {
        mainRepository.receiveHolidays(
            year = year,
            countryCode = countryCode
        )?.let { response ->
            response.map { entity -> entity.toHolidayModel() }
        }
    }

}

object Handler {
    private const val COROUTINE_TAG = "coroutineHandled"

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d(COROUTINE_TAG, "handled ${throwable.message} in $coroutineContext")
    }
}
