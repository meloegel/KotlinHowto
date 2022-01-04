package com.mloegel.howto.howto

import org.springframework.web.bind.annotation.*

@RestController
class HowToController(val service: HowToService) {
    @GetMapping("/howtos")
    fun getAllHowtos(): MutableIterable<HowTo> = service.findHowtos()


    @PostMapping("/howtos")
    fun postHowto(@RequestBody howTo: HowTo) {
        service.postHowto(howTo)
    }
}