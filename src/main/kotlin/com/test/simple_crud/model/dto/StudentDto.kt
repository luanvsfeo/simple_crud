package com.test.simple_crud.model.dto

import java.time.LocalDate

data class StudentDto (
		var id : Int = 0,
		var name: String? = null,
		var birthDate: LocalDate? = null,
		var email: String? = null
)