package com.example.randomuser.data.api.impl

import com.example.randomuser.BuildConfig
import com.example.randomuser.data.api.contract.RandomUserApi
import com.example.randomuser.model.Gender
import com.example.randomuser.model.network.NetworkResponse
import com.example.randomuser.model.network.Response
import com.example.randomuser.utils.Constants
import com.example.randomuser.utils.wrappers.safeCall
import io.ktor.client.*
import io.ktor.client.request.*

class RandomUserApiImpl(
    private val client: HttpClient
) : RandomUserApi {

    override suspend fun getUsers(
        gender: Gender,
        page: Int
    ): Response<NetworkResponse> = safeCall {
        val response = client.get<NetworkResponse> {
            url(BuildConfig.BaseUrl)
            parameter("gender", gender.value)
            parameter("results", Constants.RESULT_SIZE)
            parameter("page", page)
        }
        Response.Success(response)
    }
}