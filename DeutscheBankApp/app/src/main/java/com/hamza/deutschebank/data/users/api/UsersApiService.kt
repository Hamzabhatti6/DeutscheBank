package com.hamza.deutschebank.data.users.api

import com.hamza.deutschebank.data.users.network.response.UsersOTO
import retrofit2.Call
import retrofit2.http.GET
interface UsersApiService {
    @GET("users/")
    fun getUsersList(): Call<List<UsersOTO>>
}