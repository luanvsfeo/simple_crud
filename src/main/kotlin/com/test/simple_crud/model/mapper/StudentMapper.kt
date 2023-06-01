package com.test.simple_crud.model.mapper

import com.test.simple_crud.model.Student
import com.test.simple_crud.model.dto.StudentDto
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValuePropertyMappingStrategy


@Mapper
interface StudentMapper {
	//@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	fun updateStudentFromDto(dto: StudentDto?) : Student
}