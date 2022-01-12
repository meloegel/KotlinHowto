package com.mloegel.howto.howto

import com.mloegel.howto.user.UserService
import org.springframework.web.bind.annotation.*

@RestController
class HowToController(val service: HowToService, val userService: UserService) {
    @GetMapping("/howtos")
    fun getAllHowtos(): MutableIterable<HowTo> = service.findHowtos()

    @GetMapping("/howto/{howtoid}")
    fun getHowtoById(@PathVariable howtoid: Int): HowTo = service.findByHowtoid(howtoid)

    @GetMapping("/howtos/{category}")
    fun getHowtosByCategory(@PathVariable category: String): List<HowTo> = service.findHowtosByCategory(category)

    @GetMapping("/howtos/{userid}")
    fun getHowtosByUser(@PathVariable userid: Int): List<HowTo> {
        val user = userService.findByUserid(userid)
        return service.findHowtosByUser(user)
    }

    @GetMapping("/howtos/howto/{name}")
    fun getHowtoByName(@PathVariable name: String): HowTo = service.findHowtoByName(name)

    @PostMapping("/{userid}/howtos")
    fun postHowto(@PathVariable userid: Int, @RequestBody howTo: HowTo) {
        val user = userService.findByUserid(userid)
        service.postHowto(user, howTo)
    }
}