package com.mloegel.howto.howto

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class HowToService(val db: HowToRepository) {
    fun findHowtos(): MutableIterable<HowTo> = db.findAll()

    fun findByHowtoid(howtoid: Int): HowTo = db.findByHowtoid(howtoid)

    fun postHowto(howTo: HowTo){
        db.save(howTo)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() {
        db.deleteAll()
    }
}