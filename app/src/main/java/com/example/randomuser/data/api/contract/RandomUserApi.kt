package com.example.randomuser.data.api.contract

import com.example.randomuser.model.Gender
import com.example.randomuser.model.network.NetworkResponse
import com.example.randomuser.model.network.Response

interface RandomUserApi {

    suspend fun getUsers(
        gender: Gender,
        page: Int
    ): Response<NetworkResponse>
}