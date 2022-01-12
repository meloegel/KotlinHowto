package com.mloegel.howto

import com.mloegel.howto.howto.HowTo
import com.mloegel.howto.howto.HowToRepository
import com.mloegel.howto.user.User
import com.mloegel.howto.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = ["enabled"], havingValue = "true", matchIfMissing = true)
@Component
class SeedData : CommandLineRunner {
    @Autowired
    var userService: UserService? = null

    @Autowired
    var howToRepository: HowToRepository? = null



    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        userService?.deleteAll()

        val u1 = User(1,"admin", "password", "admin@lambdaschool.local")
        userService?.postUser(u1)
        howToRepository?.save(
            HowTo(2,"name", "description", "category", "complexity",
                User(1,"admin", "password", "admin@lambdaschool.local")))


        val u2 = User(3, "cinnamon", "1234567", "cinnamon@lambdaschool.local")
        userService?.postUser(u2)
        howToRepository?.save(
            HowTo(4,"name two", "description", "category", "complexity",
                User(3, "cinnamon", "1234567", "cinnamon@lambdaschool.local")))


        val u3 = User(5, "barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local")
        userService?.postUser(u3)
        howToRepository?.save(
            HowTo(6,"name three test", "description", "category", "complexity",
                User(5, "barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local")))


        val u4 = User(7, "puttat", "password", "puttat@school.lambda")
        userService?.postUser(u4)

        val u5 = User( 8, "misskitty", "password", "misskitty@school.lambda")
        userService?.postUser(u5)

        val u6 = User(9,"fart", "password", "email@email.com")
        userService?.postUser(u6)
    }
}