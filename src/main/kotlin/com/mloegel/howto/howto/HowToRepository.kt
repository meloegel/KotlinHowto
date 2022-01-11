package com.mloegel.howto.howto

import com.mloegel.howto.user.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface HowToRepository : CrudRepository<HowTo, String>  {
    fun findByHowtoid(howtoid: Int): HowTo

    fun findHowtosByUser(user: User): List<HowTo>

    fun findHowtosByCategory(category: String): List<HowTo>

    fun findHowtoByName(name: String): HowTo
}