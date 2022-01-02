package com.mloegel.howto.howto

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface HowToRepository : CrudRepository<HowTo, String>  {
    @Query("select * from howtos")
    fun findHowtos(): List<HowTo>
}