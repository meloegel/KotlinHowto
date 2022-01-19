package com.mloegel.howto.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.howto.howto.HowTo
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*


@Entity
@Table("USERS")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var userid:Int?,

    @Column(nullable = false, unique = true)
    var username:String,

    @Column(nullable = false)
    var password:String,

    @Column(nullable = false, unique = true)
    var email:String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["user"], allowSetters = true)
    var howTos: List<HowTo> = ArrayList<HowTo>()
)