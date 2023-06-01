package com.test.simple_crud.service

import com.test.simple_crud.model.dto.StudentDto
import com.test.simple_crud.model.exception.InvalidStudentException
import com.test.simple_crud.model.mapper.StudentMapper
import com.test.simple_crud.repository.StudentRepository
import com.test.simple_crud.utils.convertToDto
import com.test.simple_crud.utils.convertToModel
import org.mapstruct.factory.Mappers
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(
	val studentRepository: StudentRepository
) {

	private val log = LoggerFactory.getLogger(this::class.java)
	private val mapper: StudentMapper = Mappers.getMapper(StudentMapper::class.java)

	fun create(studentDto: StudentDto): StudentDto {
		log.info("m=create; step=start; studentDto=$studentDto")
		val studentBeforeSave = studentDto.convertToModel()
		if (studentBeforeSave.isValid()) {
			val studentCreated = studentRepository.save(studentBeforeSave).convertToDto()
			log.info("m=create; step=finished; studentDto=$studentDto, studentCreated=$studentCreated")
			return studentCreated
		} else {
			throw InvalidStudentException("Student invalid")
		}
	}


	fun readAll(): List<StudentDto> {
		log.info("m=readAll; step=start")
		val allStudentList = studentRepository.findAll().stream().map { it.convertToDto() }.toList()
		log.info("m=readAll; step=finished; allStudentList=$allStudentList")
		return allStudentList
	}

	fun readById(id: Int): StudentDto? {
		log.info("m=readById; step=start")
		val studentFromDb = studentRepository.findById(id)
		log.info("m=readAll; step=finished; studentFromDb=$studentFromDb")
		return if (studentFromDb.isPresent) studentFromDb.get().convertToDto() else null
	}

	fun update(studentDto: StudentDto) : StudentDto {
		log.info("m=update; step=start; studentDto=$studentDto")
		var studentFromDb = studentRepository.findById(studentDto.id)
		if (studentFromDb.isPresent) {
			//mapper.updateStudentFromDto(studentDto, studentFromDb.get())
			val response  = studentRepository.save(studentFromDb.get())
			log.info("m=update; step=finished; studentDto=$studentDto , studentFromDb=$response")
			return response.convertToDto()
		} else {
			throw Exception("Invalid Student")
		}
	}

	fun delete(id: Int): Boolean {
		log.info("m=delete; step=start; id=$id")
		val studentFromDb = studentRepository.findById(id)
		log.info("m=delete; step=current; studentFromDb=$studentFromDb")

		return if (studentFromDb.isPresent) {
			studentRepository.delete(studentFromDb.get())
			true
		} else {
			false
		}
	}
}