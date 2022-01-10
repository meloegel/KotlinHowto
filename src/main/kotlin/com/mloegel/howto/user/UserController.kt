package com.mloegel.howto.user

import org.springframework.web.bind.annotation.*

@RestController
class UserController(val service: UserService) {
    @GetMapping("/users")
    fun getAllUsers(): MutableIterable<User> = service.findUsers()

    @GetMapping("/user/{userid}")
    fun getUserById(@PathVariable userid: Int): User = service.findByUserid(userid)

    @PostMapping("/user")
    fun postUser(@RequestBody user: User) {
        service.postUser(user)
    }

    @PutMapping("/user/{userid}")
    fun updateUser(@PathVariable userid: Int, @RequestBody updatedUser: User) {
        updatedUser.userid = userid
        service.postUser(updatedUser)
    }

}