package com.mloegel.howto.steps

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.howto.howto.HowTo
import javax.persistence.*

@Entity
@Table(name = "STEPS")
data class Step(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var stepid:Int?,

    @Column(nullable = false)
    var step:String,

    @ManyToOne
    @JoinColumn(name = "howtoid", nullable = false)
    @JsonIgnoreProperties(value = ["steps", "user", "complexity", "category", "description"], allowSetters = true)
    private var howto: HowTo? = null
)
