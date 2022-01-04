package com.mloegel.howto.user

import javax.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType


@Entity
@Table("USERS")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userid:Int?
)