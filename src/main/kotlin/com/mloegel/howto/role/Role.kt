package com.mloegel.howto.role

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*

@Entity
@Table("ROLES")
data class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val roleid:Int?,

    @Column(nullable = false, unique = true)
    val name:String


        )