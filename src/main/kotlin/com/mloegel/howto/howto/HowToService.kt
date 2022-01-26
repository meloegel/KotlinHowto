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

    fun findHowtoByName(name: String): HowTo = db.findHowtoByName(name)

    fun findHowtoByNameContaining(name: String): List<HowTo> = db.findHowtosByNameContainingIgnoreCase(name)

    fun findHowtoByComplexity(complexity: String): List<HowTo> = db.findHowtosByComplexity(complexity)

    @Transactional
    fun postHowto(user: User ,howTo: HowTo){
        howTo.user = user
        db.save(howTo)
    }

    @Transactional
    fun deleteHowto(howTo: HowTo) = db.delete(howTo)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()
}