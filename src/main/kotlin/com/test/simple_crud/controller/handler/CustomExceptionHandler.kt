package com.test.simple_crud.controller.handler

import com.test.simple_crud.model.exception.InvalidStudentException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

	private val log = LoggerFactory.getLogger(this::class.java)

	@ExceptionHandler(InvalidStudentException::class)
	fun handleInvalidStudentException(exception: Exception, request: WebRequest?): ResponseEntity<*>? {
		log.error("m=handleInvalidStudentException;exception=$exception")
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(listOf(exception.message.orEmpty()))
	}
}