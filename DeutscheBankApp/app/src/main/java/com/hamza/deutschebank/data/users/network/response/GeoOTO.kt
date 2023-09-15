package com.hamza.deutschebank.data.users.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoOTO(@Json(name = "lat") val lat: String?,
                  @Json(name = "lng") val lng: String?)
