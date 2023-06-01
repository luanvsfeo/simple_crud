package com.test.simple_crud.model

import com.test.simple_crud.model.exception.InvalidStudentException
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.apache.commons.validator.routines.EmailValidator
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Entity
data class Student(

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Int?,

	var name: String,

	var birthDate: LocalDate?,

	var email: String,

	var countryCommonName: String?,

	var countryOfficialName: String?
) {

	private fun isAgeInsideRange(): Boolean {
		val age = ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());

		if (!(age < 14 || age > 100)) {
			return true
		} else {
			throw InvalidStudentException("Age out of range")
		}
	}

	private fun isEmailValid(): Boolean {
		if (EmailValidator.getInstance().isValid(this.email)) {
			return true
		} else {
			throw InvalidStudentException("Invalid email")
		}
	}

	fun isValid(): Boolean {
		return this.isAgeInsideRange() && this.isEmailValid()
	}
}