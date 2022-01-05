package com.mloegel.howto.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.howto.howto.HowTo
import com.mloegel.howto.role.UserRoles
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*


@Entity
@Table("USERS")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userid:Int?,

    @Column(nullable = false, unique = true)
    val username:String,

    @Column(nullable = false, unique = true)
    val password:String,

    @Column(nullable = false, unique = true)
    val email:String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["user"], allowSetters = true)
    private var roles: Set<UserRoles?>? = HashSet<UserRoles?>(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["user"], allowSetters = true)
    private var howTos: List<HowTo?>? = ArrayList<HowTo?>()
)