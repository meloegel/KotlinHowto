package com.mloegel.howto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HowtoApplication

fun main(args: Array<String>) {
	runApplication<HowtoApplication>(*args)
}
