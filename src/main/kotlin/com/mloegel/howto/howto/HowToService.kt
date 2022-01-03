package com.mloegel.howto.howto

import org.springframework.stereotype.Service

@Service
class HowToService(val db: HowToRepository) {
    fun findHowtos(): List<HowTo> = db.findHowtos()

    fun postHowto(howTo: HowTo){
        db.save(howTo)
    }

}