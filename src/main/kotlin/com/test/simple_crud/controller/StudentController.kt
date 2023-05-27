package com.test.simple_crud.controller

import com.test.simple_crud.dto.StudentDto
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
		studentService.readAll()
	}

	@PostMapping
	fun post(studentDto: StudentDto) {
		studentService.create(studentDto)
	}

	@DeleteMapping("/{id}")
	fun delete(id : Int) {
		studentService.delete(id)
	}

	@PutMapping("/{id}")
	fun put() {
		studentService.update()
	}

	@PatchMapping("/{id}")
	fun patch() {
		studentService.update()
	}
}