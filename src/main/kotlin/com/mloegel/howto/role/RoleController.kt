package com.mloegel.howto.role

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RoleController(val service:RoleService) {
    @GetMapping("/roles")
    fun getAllRoles(): MutableIterable<Role> = service.findAllRoles()

    @PostMapping("/role")
    fun postRole(@RequestBody role:Role) {
        service.postRole(role)
    }
}