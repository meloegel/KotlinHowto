package com.mloegel.howto.howto

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*

@Entity
@Table("HOWTOS")
data class HowTo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val howtoid:Int?,

    @Column(nullable = false, unique = true)
    val name:String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val category: String,

    @Column
    val complexity:String
)
