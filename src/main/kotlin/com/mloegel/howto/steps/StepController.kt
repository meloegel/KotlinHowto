package com.mloegel.howto.steps

import com.mloegel.howto.howto.HowToService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class StepController(val service: StepService, val howToService: HowToService) {
    @GetMapping("/steps")
    fun getAllSteps(): MutableIterable<Step> = service.findAllSteps()

    @GetMapping("/step/{stepid}")
    fun getStepById(@PathVariable stepid: Int): Step {
        try {
            return service.findStepById(stepid)
        }catch (exception: EmptyResultDataAccessException) {
            throw Exception("step with id $stepid not found!")
        }
    }

    @GetMapping("/steps/{howtoid}")
    fun getStepsByHowto(@PathVariable howtoid: Int): List<Step> {
        try {
            val howto = howToService.findByHowtoid(howtoid)
            return service.findAllStepsForHowto(howto)
        }catch (exception: EmptyResultDataAccessException) {
            throw Exception("Howto with id $howtoid not found!")
        }
    }
}