package com.test.simple_crud.controller

import com.test.simple_crud.model.dto.StudentDto
import com.test.simple_crud.service.StudentService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(val studentService: StudentService) {

	private val log = LoggerFactory.getLogger(this::class.java)

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun get(): List<StudentDto> {
		log.info("m=get; step=start")
		val response = studentService.readAll()
		log.info("m=get; step=finished; result= $response")
		return response
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun post(@RequestBody studentDto: StudentDto): StudentDto {
		log.info("m=post; step=start")
		val response = studentService.create(studentDto)
		log.info("m=post; step=finished")
		return response
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun delete(id: Int) {
		log.info("m=delete; step=start")
		studentService.delete(id)
		log.info("m=delete; step=finished")
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun put() {
		log.info("m=put; step=start")
		studentService.update()
		log.info("m=put; step=finished")
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun patch() {
		log.info("m=patch; step=start")
		studentService.update()
		log.info("m=patch; step=finished")
	}
}