package com.mloegel.howto.role

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.howto.user.User
import javax.persistence.*


@Entity
@Table(name = "USERROLES")
@IdClass(UserRolesId::class)
data class UserRoles(
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = ["roles"], allowSetters = true)
    private var user: User? = null,

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties(value = ["users"], allowSetters = true)
    private val role: Role? = null

    )
