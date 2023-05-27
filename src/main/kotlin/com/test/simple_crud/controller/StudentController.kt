package com.test.simple_crud.controller

import com.test.simple_crud.service.StudentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/student")
class StudentController(val studentService: StudentService) {
	@GetMapping
	fun get() {
		studentService.read()
	}

	@PostMapping
	fun post() {
		studentService.create()
	}

	@DeleteMapping
	fun delete() {
		studentService.delete()
	}

	@PutMapping
	fun put() {
		studentService.update()
	}

	@PatchMapping
	fun patch() {
		studentService.update()
	}
}