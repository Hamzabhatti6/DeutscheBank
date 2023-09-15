package com.hamza.deutschebank.core.network.mapper

import com.hamza.deutschebank.core.domain.Error
import okhttp3.ResponseBody

interface ErrorMapper {

    fun map(response: ResponseBody) : Error

    fun getApiResponseType() : Class<ResponseBody>
}