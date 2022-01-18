package com.mloegel.howto.steps

import com.mloegel.howto.howto.HowTo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class StepService(val db: StepRepository) {
    fun findAllSteps(): MutableIterable<Step> = db.findAll()

    fun findAllStepsForHowto(howTo: HowTo): List<Step> = db.findByHowto(howTo)

    fun findStepById(stepid: Int): Step = db.findByStepid(stepid)

    @Transactional
    fun postStep(howTo: HowTo, step: Step){
        step.howto = howTo
        db.save(step)
    }

    @Transactional
    fun deleteStep(step: Step) = db.delete(step)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()
}