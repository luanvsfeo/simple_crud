package com.test.simple_crud.model.exception

data class InvalidStudentException(override val message: String?) : Exception(message) {
}