package com.mloegel.howto.howto

import com.mloegel.howto.user.UserService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class HowToController(val service: HowToService, val userService: UserService) {
    @GetMapping("/howtos")
    fun getAllHowtos(): MutableIterable<HowTo> = service.findHowtos()

    @GetMapping("/howtos/howtoid/{howtoid}")
    fun getHowtoById(@PathVariable howtoid: Int): HowTo {
        try{
            return service.findByHowtoid(howtoid)
        }catch (exception: EmptyResultDataAccessException) {
            throw Exception("Howto with id $howtoid not found!")
        }
    }

    @GetMapping("/howtos/category/{category}")
    fun getHowtosByCategory(@PathVariable category: String): List<HowTo> = service.findHowtosByCategory(category)

    @GetMapping("/howtos/user/{userid}")
    fun getHowtosByUser(@PathVariable userid: Int): List<HowTo> {
        try {
            val user = userService.findByUserid(userid)
                return service.findHowtosByUser(user)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("user with id $userid not found!")
        }
    }

    @GetMapping("/howtos/howto/{name}")
    fun getHowtoByName(@PathVariable name: String): HowTo{
        try {
            return service.findHowtoByName(name)
        } catch (exception: EmptyResultDataAccessException){
            throw Exception("Howto with name $name not found!")
        }
    }

    @PostMapping("/{userid}/howtos")
    fun postHowto(@PathVariable userid: Int, @RequestBody howTo: HowTo) {
        val user = userService.findByUserid(userid)
        service.postHowto(user, howTo)
    }
}