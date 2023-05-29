package com.test.simple_crud.controller.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

	// TODO - criar exceptions customizados para cada situacao

	@ExceptionHandler(Exception::class)
	fun handleGenericException(exception: Exception, request: WebRequest?): ResponseEntity<*>? {
		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(listOf("azedou")) //exception.message.orEmpty()
	}
}