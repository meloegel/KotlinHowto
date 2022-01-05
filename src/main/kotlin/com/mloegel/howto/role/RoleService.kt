package com.mloegel.howto.role

import org.springframework.stereotype.Service

@Service
class RoleService(val db: RoleRepository) {
    fun findAllRoles() : MutableIterable<Role> = db.findAll()

    fun postRole(role: Role) {
        db.save(role)
    }
}