package com.mloegel.howto.howto

import com.mloegel.howto.user.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class HowToService(val db: HowToRepository) {
    fun findHowtos(): MutableIterable<HowTo> = db.findAll()

    fun findByHowtoid(howtoid: Int): HowTo = db.findByHowtoid(howtoid)

    fun findHowtosByCategory(category: String): List<HowTo> = db.findHowtosByCategory(category)

    fun findHowtosByUser(user: User): List<HowTo> = db.findHowtosByUser(user)

    fun postHowto(howTo: HowTo){
        db.save(howTo)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() {
        db.deleteAll()
    }
}