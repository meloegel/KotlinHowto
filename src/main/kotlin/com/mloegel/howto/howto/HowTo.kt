package com.mloegel.howto.howto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Table("HOWTOS")
data class HowTo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int?,
    val name:String,
    val description: String,
    val category: String,
    val complexity:String
)
