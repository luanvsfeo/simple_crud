package com.test.simple_crud.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Student(

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		var id : Int?,

		var name: String,

		var birthDate: LocalDate?,

		var email: String,

		var countryCommonName : String?,

		var countryOfficialName : String?
)