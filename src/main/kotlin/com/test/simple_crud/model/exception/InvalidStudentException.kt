package com.test.simple_crud.model.exception

class InvalidStudentException(override val message: String?) : Exception(message) {
}