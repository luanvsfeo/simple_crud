package com.test.simple_crud.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Entity
class Student(

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
		return !(age < 14 || age > 100)
	}

	fun isValid(): Boolean {
		return this.isAgeInsideRange()
	}
}