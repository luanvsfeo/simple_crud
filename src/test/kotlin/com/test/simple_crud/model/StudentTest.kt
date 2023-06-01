package com.test.simple_crud.model

import com.test.simple_crud.model.exception.InvalidStudentException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDate

class StudentTest {

	@Test
	fun isValidTrue() {
		val student = mockStudent("teste@teste.com", LocalDate.of(1999, 5, 12))

		Assertions.assertTrue(student.isValid())
	}

	@Test
	fun isValidFalseEmailWrong() {
		val student = mockStudent("testea", LocalDate.of(1999, 5, 12))


		val exception: Exception = assertThrows(InvalidStudentException::class.java) { student.isValid()}

		Assertions.assertTrue(exception.message.equals("Invalid email"))
	}

	@Test
	fun isValidFalseDateLess() {
		val student = mockStudent("testea@gmail.com", LocalDate.of(2021, 5, 12))

		val exception: Exception = assertThrows(InvalidStudentException::class.java) { student.isValid()}


		Assertions.assertTrue(exception.message.equals("Age out of range"))
	}


	private fun mockStudent(email: String, birthDate: LocalDate): Student {
		return Student(
			id = 1,
			name = "teste",
			birthDate = birthDate,
			email = email,
			countryCommonName = "",
			countryOfficialName = ""
		)
	}
}