package com.mloegel.howto.role

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class RoleService(val db: RoleRepository) {
    fun findAllRoles() : MutableIterable<Role> = db.findAll()

    fun findByRoleid(roleid: Int): Role = db.findByRoleid(roleid)

    fun postRole(role: Role) {
        db.save(role)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() {
        db.deleteAll()
    }
}