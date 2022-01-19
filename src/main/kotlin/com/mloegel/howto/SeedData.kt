package com.mloegel.howto

import com.mloegel.howto.howto.HowTo
import com.mloegel.howto.howto.HowToRepository
import com.mloegel.howto.steps.Step
import com.mloegel.howto.steps.StepRepository
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

    @Autowired
    var stepRepository: StepRepository? = null

    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        userService?.deleteAll()

        val u1 = User(1,"admin", "password", "admin@lambdaschool.local")
        userService?.postUser(u1)
        howToRepository?.save(
            HowTo(2,"name", "description", "category", "complexity",
                User(1,"admin", "password", "admin@lambdaschool.local")))
        stepRepository?.save(
            Step( 3,"step1",
                HowTo(2,"name", "description", "category", "complexity")))


        val u2 = User(4, "cinnamon", "1234567", "cinnamon@lambdaschool.local")
        userService?.postUser(u2)
        howToRepository?.save(
            HowTo(5,"name two", "description", "category", "complexity",
                User(4, "cinnamon", "1234567", "cinnamon@lambdaschool.local")))


        val u3 = User(6, "barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local")
        userService?.postUser(u3)
        howToRepository?.save(
            HowTo(7,"name three test", "description", "category", "complexity",
                User(6, "barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local")))


        val u4 = User(8, "puttat", "password", "puttat@school.lambda")
        userService?.postUser(u4)
        howToRepository?.save(
            HowTo(9,"fart name", "description", "category", "complexity",
                User(8,"admin", "password", "admin@lambdaschool.local")))


        val u5 = User( 10, "misskitty", "password", "misskitty@school.lambda")
        userService?.postUser(u5)

        val u6 = User(11,"fart", "password", "email@email.com")
        userService?.postUser(u6)
    }
}