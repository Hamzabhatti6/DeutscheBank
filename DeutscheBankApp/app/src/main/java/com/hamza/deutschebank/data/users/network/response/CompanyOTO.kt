package com.hamza.deutschebank.data.users.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyOTO(@Json(name = "name") val name: String?,
                      @Json(name = "catchPhrase") val catchPhrase: String?,
                      @Json(name = "bs") val bs: String?)
