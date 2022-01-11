package com.mloegel.howto.user

import com.mloegel.howto.role.RoleService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService(val db: UserRepository, val roleService: RoleService) {
    fun findUsers(): MutableIterable<User> = db.findAll()

    fun findByUserid(userid: Int): User = db.findByUserid(userid)

    @Transactional
    fun updateUser(userid: Int, updatedUser:User): User {
        var currentUser = db.findByUserid(userid)
        currentUser.username = updatedUser.username
        currentUser.password = updatedUser.password
        currentUser.email = updatedUser.email
//        if (updatedUser.roles?.isNotEmpty() == true) {
//            for (role in updatedUser.roles!!) {
//                role.
//                UserRoles(currentUser, role)
//            }
//        }

        return db.save(currentUser)
    }

    @Transactional
    fun postUser(user: User) = db.save(user)

    @Transactional
    fun deleteUser(user: User) = db.delete(user)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()

  }