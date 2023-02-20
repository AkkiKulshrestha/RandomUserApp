package com.example.randomuser.data.repository.contract

import com.example.randomuser.model.Gender
import com.example.randomuser.model.Resource
import com.example.randomuser.model.User
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getUsers(
        gender: Gender,
        page: Int
    ): Flow<Resource<List<User>>>
}