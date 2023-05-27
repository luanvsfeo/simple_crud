package com.test.simple_crud.service

import com.test.simple_crud.dto.StudentDto
import com.test.simple_crud.repository.StudentRepository
import com.test.simple_crud.utils.convertToDto
import com.test.simple_crud.utils.convertToModel
import org.springframework.stereotype.Service

@Service
class StudentService(val studentRepository: StudentRepository) {

	// colocar logs
	fun create(studentDto: StudentDto) {
		val studentBeforeSave = studentDto.convertToModel()
		studentRepository.save(studentBeforeSave)
	}


	fun readAll(): List<StudentDto> {
		return studentRepository.findAll().stream().map { it.convertToDto() }.toList()
	}

	fun update() {

	}

	fun delete(id: Int): Boolean {
		val studentFromDb = studentRepository.findById(id)
		return if (studentFromDb.isPresent) {
			studentRepository.delete(studentFromDb.get())
			true
		} else {
			false
		}
	}
}