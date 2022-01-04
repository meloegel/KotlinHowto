package com.mloegel.howto.howto

import org.springframework.stereotype.Service

@Service
class HowToService(val db: HowToRepository) {
    fun findHowtos(): MutableIterable<HowTo> = db.findAll()

    fun postHowto(howTo: HowTo){
        db.save(howTo)
    }


}