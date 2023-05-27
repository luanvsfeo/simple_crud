package com.test.simple_crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleCrudApplication

fun main(args: Array<String>) {
	runApplication<SimpleCrudApplication>(*args)
}


/*
	- teste unitario
	- error handler
	- logging
	- validacao de idade
	- validacao de email
	- https://restcountries.com/#endpoints-latest-added-enpoint-independent
*/