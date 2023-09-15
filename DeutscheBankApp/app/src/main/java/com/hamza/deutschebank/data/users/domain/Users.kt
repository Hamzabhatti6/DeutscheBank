package com.hamza.deutschebank.data.users.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users( val id: Int?,
                  val name: String?,
                  val username: String?,
                  val email: String?,
                  val phone: String?,
                  val street: String?,
                  val suite: String?,
                  val city: String?,
                  val company: String?
                  ): Parcelable {}
