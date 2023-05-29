package com.test.simple_crud.controller.handler

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

	// TODO - criar exceptions customizados para cada situacao
	private val log = LoggerFactory.getLogger(this::class.java)

	@ExceptionHandler(Exception::class)
	fun handleGenericException(exception: Exception, request: WebRequest?): ResponseEntity<*>? {
		log.error("m=handleGenericException;exception=$exception")
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(listOf(exception.message.orEmpty()))
	}
}