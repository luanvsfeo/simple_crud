package com.test.simple_crud.utils

import com.test.simple_crud.model.dto.StudentDto
import com.test.simple_crud.model.Student

fun StudentDto.convertToModel(): Student {
	return Student(
		id = null,
		name = this.name.orEmpty(),
		email = this.email.orEmpty(),
		birthDate = this.birthDate,
		countryCommonName = null,
		countryOfficialName = null
	)
}

fun Student.convertToDto(): StudentDto {
	return StudentDto(
		name = this.name,
		birthDate = this.birthDate,
		email = this.email
	)
}
