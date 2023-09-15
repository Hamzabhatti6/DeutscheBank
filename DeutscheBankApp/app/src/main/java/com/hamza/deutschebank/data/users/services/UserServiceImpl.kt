package com.hamza.deutschebank.data.users.services

import com.hamza.deutschebank.core.domain.ApiResult
import com.hamza.deutschebank.core.network.RetrofitCallExecutor
import com.hamza.deutschebank.data.users.api.UsersApiService
import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.data.users.network.mappers.UsersMapper
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val apiService: UsersApiService
): UserService {

    override suspend fun getUsers(): ApiResult<UsersData> {
        val call = apiService.getUsersList()

        return RetrofitCallExecutor(domainMapper = UsersMapper()).execute(call)
    }


}