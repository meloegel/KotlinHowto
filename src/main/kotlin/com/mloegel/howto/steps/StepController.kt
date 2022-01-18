package com.mloegel.howto.steps

import com.mloegel.howto.howto.HowToService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*


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

    @PostMapping("/{howtoid}/step")
    fun postStep(@PathVariable howtoid: Int, @RequestBody step: Step) {
        val howto = howToService.findByHowtoid(howtoid)
        service.postStep(howto, step)
    }

    @DeleteMapping("/step/{stepid}")
    fun deleteStep(@PathVariable stepid: Int) {
        try {
            val step = service.findStepById(stepid)
            service.deleteStep(step)
        }catch (exception: EmptyResultDataAccessException) {
            throw Exception("Step with id $stepid not found!")
        }
    }
}