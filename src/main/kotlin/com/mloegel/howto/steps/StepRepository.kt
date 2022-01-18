package com.mloegel.howto.steps

import com.mloegel.howto.howto.HowTo
import org.springframework.data.repository.CrudRepository

interface StepRepository: CrudRepository<Step, String> {
    fun findByStepid(stepid: Int): Step

    fun findByHowto(howTo: HowTo): List<Step>
}