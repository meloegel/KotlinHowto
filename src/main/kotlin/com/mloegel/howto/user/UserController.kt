package com.mloegel.howto.user

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val service: UserService) {
    @GetMapping("/users")
    fun getAllUsers(): MutableIterable<User> = service.findUsers()

    @GetMapping("/user/{userid}")
    fun getUserById(@PathVariable userid: Int): User {
        try {
            return service.findByUserid(userid)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("user with id $userid not found!")
        }
    }

    @GetMapping("/users/{username}/user")
    fun getUserByUsername(@PathVariable username: String) = service.findByUsername(username)

    @GetMapping("/users/user/{username}")
    fun findUsername(@PathVariable username: String) = service.findByName(username)

    @PostMapping("/user")
    fun postUser(@RequestBody user: User) {
        service.postUser(user)
    }

    @PutMapping("/user/{userid}")
    fun updateUser(@PathVariable userid: Int, @RequestBody updatedUser: User) {
        updatedUser.userid = userid
        service.postUser(updatedUser)
    }

    @DeleteMapping("/user/{userid}")
    fun deleteUser(@PathVariable userid: Int) {
        try {
            val user = service.findByUserid(userid)
            service.deleteUser(user)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("user with id $userid not found!")
        }
    }
}