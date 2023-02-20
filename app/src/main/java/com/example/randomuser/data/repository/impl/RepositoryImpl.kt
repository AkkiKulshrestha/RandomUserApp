package com.example.randomuser.data.repository.impl

import com.example.randomuser.data.api.contract.RandomUserApi
import com.example.randomuser.data.repository.contract.Repository
import com.example.randomuser.model.Gender
import com.example.randomuser.model.Resource
import com.example.randomuser.model.User
import com.example.randomuser.model.network.Response
import com.example.randomuser.model.network.parse
import com.example.randomuser.utils.Constants
import com.example.randomuser.utils.wrappers.resourceFlow
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: RandomUserApi
) : Repository {

    override fun getUsers(
        gender: Gender,
        page: Int
    ): Flow<Resource<List<User>>> = resourceFlow {
        val result = api.getUsers(
            gender = gender,
            page = page
        )
        if (result is Response.Success) {
            emit(Resource.Success(data = result.data?.results?.parse()))
        } else {
            emit(Resource.Error(msg = result.msg ?: Constants.REQUEST_FAILED_MESSAGE))
        }
    }
}