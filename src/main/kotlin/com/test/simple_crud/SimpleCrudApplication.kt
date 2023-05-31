package com.test.simple_crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleCrudApplication

fun main(args: Array<String>) {
	runApplication<SimpleCrudApplication>(*args)
}


/*
	- teste integrado
	- teste de ponta a ponta  (controller,service,repository)
	- https://restcountries.com/#endpoints-latest-added-enpoint-independent
*/