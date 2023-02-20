package com.example.randomuser.utils.extensions

import android.util.Log
import com.example.randomuser.model.Resource
import com.example.randomuser.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

fun <T> Flow<Resource<T>>.asResourceFlow(
    doRetry: Boolean = false
): Flow<Resource<T>> = onStart { emit(Resource.Loading()) }
    .distinctUntilChanged()
    .retryWhen { cause, attempt ->
        // Exponential backoff of 1 second on each retry
        if (attempt > 1) delay(1000 * attempt)

        // Do not retry for IllegalArgument or 3 attempts are reached
        if (cause is IllegalArgumentException || attempt == 3L) false
        else doRetry
    }
    .catch {
        it.printStackTrace()
        when (it) {
            is IllegalArgumentException -> {
                Log.d("RF", "TestLog: IllegalArgumentException")
                emit(Resource.Error(msg = Constants.REQUEST_FAILED_MESSAGE))
            }
            else -> {
                Log.d("RF", "TestLog: Exception")
                emit(Resource.Error(msg = Constants.REQUEST_FAILED_MESSAGE))
            }
        }
    }
    .flowOn(Dispatchers.IO)