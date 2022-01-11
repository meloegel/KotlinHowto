package com.mloegel.howto

import com.mloegel.howto.howto.HowTo
import com.mloegel.howto.howto.HowToRepository
import com.mloegel.howto.howto.HowToService
import com.mloegel.howto.role.Role
import com.mloegel.howto.role.RoleService
import com.mloegel.howto.role.UserRoles
import com.mloegel.howto.user.User
import com.mloegel.howto.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import kotlin.collections.HashSet


@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = ["enabled"], havingValue = "true", matchIfMissing = true)
@Component
class SeedData : CommandLineRunner {
    @Autowired
    var roleService: RoleService? = null

    @Autowired
    var userService: UserService? = null

    @Autowired
    var howToService: HowToService? = null

    @Autowired
    var howToRepository: HowToRepository? = null



    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        userService?.deleteAll()
        roleService?.deleteAll()
        val r1 = Role(1, "admin")
        val r2 = Role(2, "user")
        val r3 = Role(3, "data")
        roleService?.postRole(r1)
        roleService?.postRole(r2)
        roleService?.postRole(r3)



        val u1 = User(1,"admin", "password", "admin@lambdaschool.local")
        userService?.postUser(u1)
        howToRepository?.save(
            HowTo(1,"name", "description", "category", "complexity",
                User(4,"admin", "password", "admin@lambdaschool.local")))

//        val set = HashSet<UserRoles>()
//        set.add(UserRoles(u1, r1))
//        set.add(UserRoles(u1, r2))
//        set.add(UserRoles(u1, r3))
//        u1.roles = set
//        userService?.postUser(u1)


//
//
//        // admin, data, user
//        val u1 = User(1,"admin", "password", "admin@lambdaschool.local")
//        u1.getRoles().add(UserRoles(u1, r1))
//        u1.getRoles().add(UserRoles(u1, r2))
//        u1.getRoles().add(UserRoles(u1, r3))
//        u1.getHowtos().add(HowTo(1,"name", "description", "category", "complexity", u1))
//        userService?.postUser(u1)
//
//        // data, user
//        val u2 = User(2, "cinnamon", "1234567", "cinnamon@lambdaschool.local")
//        u2.getHowTos().add(HowTo(2,"name two", "description", "category", "complexity", u2))
//        u2.getRoles().add(UserRoles(u2, r2))
//        u2.getRoles().add(UserRoles(u2, r3))
//        userService?.postUser(u2)
//
//        // user
//        val u3 = User(3, "barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local")
//        u3.getRoles().add(UserRoles(u3, r2))
//        u3.getHowTos().add(HowTo(3,"name three test", "description", "category", "complexity",u3))
//
//        userService?.postUser(u3)
//        val u4 = User(4, "puttat", "password", "puttat@school.lambda")
//        u4.getRoles().add(UserRoles(u4, r2))
//        userService?.postUser(u4)
//
//        val u5 = User( 5, "misskitty", "password", "misskitty@school.lambda")
//        u5.getRoles().add(UserRoles(u5, r2))
//        userService?.postUser(u5)
//
//        val u6 = User(6,"fart", "password", "email@email.com")
//        u6.getRoles().add(UserRoles(u6, r1))
//        u6.getRoles().add(UserRoles(u6, r2))
//        u6.getRoles().add(UserRoles(u6, r3))
//        userService?.postUser(u6)
//

    }
}