package com.test.simple_crud.repository

import com.test.simple_crud.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student,Int> {
}