package com.mloegel.howto.user

import org.springframework.stereotype.Service

@Service
class UserService(val db: UserRepository) {
    fun findUsers(): MutableIterable<User> = db.findAll()

    fun postUser(user: User) {
        db.save(user)
    }
  }