package com.test.simple_crud.model

import java.time.LocalDate

class Student(
		var name: String,
		var birthDate: LocalDate,
		var email: String,
		var countryCommonName : String,
		var countryOfficialName : String
)