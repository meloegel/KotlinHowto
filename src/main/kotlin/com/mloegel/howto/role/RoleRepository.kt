package com.mloegel.howto.role

import org.springframework.data.repository.CrudRepository

interface RoleRepository : CrudRepository<Role, String> {
    fun findByRoleid(roleid: Int): Role
}