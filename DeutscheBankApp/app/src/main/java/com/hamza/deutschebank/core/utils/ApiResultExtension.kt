package com.hamza.deutschebank.core.utils

import com.hamza.deutschebank.core.domain.ApiResult


fun ApiResult<*>.isError(): Boolean {
    return error != null
}

fun ApiResult<*>.isSuccess(): Boolean {
    return !isError()
}