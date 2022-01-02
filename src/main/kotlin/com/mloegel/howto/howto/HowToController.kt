package com.mloegel.howto.howto

import org.springframework.web.bind.annotation.*

@RestController
class HowToController(val service: HowToService) {
    @GetMapping("/howtos")
    fun getAllHowtos(): List<HowTo> = service.findHowtos()

    @GetMapping("/howto/{howtoid}")
    fun getHowtoById(@PathVariable howtoid: Int) = service.findHowtoById(howtoid)

    @PostMapping("/howtos")
    fun postHowto(@RequestBody howTo: HowTo) {
        service.postHowto(howTo)
    }
}