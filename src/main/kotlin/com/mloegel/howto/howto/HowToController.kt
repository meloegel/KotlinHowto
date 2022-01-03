package com.mloegel.howto.howto

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HowToController(val service: HowToService) {
    @GetMapping("/howtos")
    fun getAllHowtos(): List<HowTo> = service.findHowtos()

    @PostMapping("/howtos")
    fun postHowto(@RequestBody howTo: HowTo) {
        service.postHowto(howTo)
    }
}