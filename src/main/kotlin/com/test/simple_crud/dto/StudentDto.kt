package com.test.simple_crud.dto

import java.time.LocalDate

class StudentDto (
		var name: String? = null,
		var birthDate: LocalDate? = null,
		var email: String? = null
)