package com.mloegel.howto.howto

import javax.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
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
