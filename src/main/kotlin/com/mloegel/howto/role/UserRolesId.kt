package com.mloegel.howto.role

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
data class UserRolesId(
    private var user: Long = 0,
    private val role: Long = 0

):Serializable
