package com.mloegel.howto.user

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, String> {
    fun findByUserid(userid: Int): User
}