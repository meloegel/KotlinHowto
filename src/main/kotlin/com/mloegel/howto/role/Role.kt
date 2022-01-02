package com.mloegel.howto.role

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import javax.persistence.*

data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val roleid:Int?,

    @Column(nullable = false, unique = true)
    val name:String,

    @OneToMany(mappedBy = "role", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["role"], allowSetters = true)
    private var users: Set<UserRoles?>? = HashSet()
)
