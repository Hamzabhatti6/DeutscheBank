package com.hamza.deutschebank.data.users.services

import com.hamza.deutschebank.core.domain.ApiResult
import com.hamza.deutschebank.data.users.domain.UsersData

interface UserService {
    suspend fun getUsers(): ApiResult<UsersData>
}