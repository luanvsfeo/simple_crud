package com.test.simple_crud.model.dto

import java.time.LocalDate

class StudentDto (
		var name: String? = null,
		var birthDate: LocalDate? = null,
		var email: String? = null
)