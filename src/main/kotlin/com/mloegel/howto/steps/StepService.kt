package com.mloegel.howto.steps

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class StepService(val db: StepRepository) {
    fun findAllSteps(): MutableIterable<Step> = db.findAll()

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()
}