package com.mloegel.howto.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService(val db: UserRepository) {
    fun findUsers(): MutableIterable<User> = db.findAll()

    fun findByUserid(userid: Int): User = db.findByUserid(userid)

    @Transactional
    fun postUser(user: User) = db.save(user)

    @Transactional
    fun deleteUser(user: User) = db.delete(user)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()

  }