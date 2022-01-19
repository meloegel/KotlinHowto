package com.mloegel.howto.howto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.howto.steps.Step
import com.mloegel.howto.user.User
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
    val complexity:String,

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = ["howTos", "roles", "email"], allowSetters = true)
    var user: User? = null,

    @OneToMany(mappedBy = "stepid", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["howtoid"], allowSetters = true)
    val steps: List<Step> = ArrayList<Step>()
)
