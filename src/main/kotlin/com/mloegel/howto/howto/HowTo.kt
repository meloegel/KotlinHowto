package com.mloegel.howto.howto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("HOWTOS")
data class HowTo(
    @Id
    val id:String?,
    val name:String,
    val description: String,
    val category: String,
    val complexity:String
)
