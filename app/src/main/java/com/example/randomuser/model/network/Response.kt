package com.example.randomuser.model.network

import com.example.randomuser.utils.Constants

sealed class Response<T>(val msg: String? = null, val data: T? = null) {
    class Success<T>(data: T?) : Response<T>(data = data)
    class UnknownHostException<T> : Response<T>()
    class InvalidPathException<T> : Response<T>(msg = Constants.ERROR_MESSAGE_INVALID_PATH)
    class InvalidRequestException<T> : Response<T>(msg = Constants.ERROR_MESSAGE_INVALID_REQUEST)
    class ServerException<T> : Response<T>(msg = Constants.ERROR_MESSAGE_SERVER_EXCEPTION)
    class UnknownException<T> : Response<T>(msg = Constants.ERROR_MESSAGE_UNKNOWN)
}