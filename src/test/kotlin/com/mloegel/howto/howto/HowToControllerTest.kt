package com.mloegel.howto.howto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


internal class HowToControllerTest() {
    @Autowired
    var howtoService: HowToService? = null

    @Test
    fun `Get howto by id`() {
       val howto = howtoService?.findByHowtoid(2)
        if (howto != null) {
            assertThat(howto.howtoid).isEqualTo(2)
        }
    }

    @Test
    fun getHowtoById() {
    }

    @Test
    fun getHowtosByCategory() {
    }

    @Test
    fun getHowtosByUser() {
    }

    @Test
    fun getHowtoByName() {
    }

    @Test
    fun getHowtoByNameContaining() {
    }

    @Test
    fun postHowto() {
    }

    @Test
    fun deleteHowto() {
    }
}